// Enabling the drawing
RenderSystem.disableDepthTest();
RenderSystem.depthMask(false);
RenderSystem.enableBlend();
RenderSystem.setShader(GameRenderer::getPositionTexShader);
RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
RenderSystem.setShaderColor(1, 1, 1, 1);
event.getMatrixStack().pushPose();

ArrayList<Object> array = GetPositionForWaypoint.GetPositionForWaypoint(w, h, x, y, z, entity.getYRot(), entity.getXRot(), 100, -55, 100);
int screenX = (int) (array.get(1));
int screenY = (int) (array.get(2));
// Draw red point
if ((Boolean) array.get(0)){
	Overlay.fill(event.getMatrixStack(), (int) (screenX - 2), (int) (screenY - 2), (int) (screenX + 2), (int) (screenY + 2), (255 << 24) | (10 << 16) | (201 << 8) | 61);
}else {
	Overlay.fill(event.getMatrixStack(), (int) (screenX - 2), (int) (screenY - 2), (int) (screenX + 2), (int) (screenY + 2), (255 << 24) | (255 << 16) | (0 << 8) | 0);
}

// Stop the drawing
RenderSystem.depthMask(true);
RenderSystem.defaultBlendFunc();
RenderSystem.enableDepthTest();
RenderSystem.disableBlend();
RenderSystem.setShaderColor(1, 1, 1, 1);
event.getMatrixStack().popPose();