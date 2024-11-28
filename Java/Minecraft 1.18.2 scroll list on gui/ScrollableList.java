import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractSelectionList;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.util.Mth;

// Déclaration de la classe pour la liste scrollable
public class ScrollableList extends AbstractSelectionList<ScrollableList.Entry>  {
	private int selectedIndex = -1;
	private int height;
	private int width;
	private int y;
	private int x;
	private Minecraft minecraft;

	public ScrollableList(Minecraft minecraft, int x, int y, int itemWidth, int itemHeight) {
		super(minecraft, itemWidth, itemHeight, y, y + itemHeight, 50); // 20 = hauteur d'un élément
		this.setLeftPos(x); // Définit la position horizontale
		this.height = itemHeight;
		this.width = itemWidth;
		this.x = x;
		this.y = y;
		this.minecraft = minecraft;

		// Ajoute des entrées
		for (int i = 0; i < 20; i++) {
			this.addEntry(new Entry("Item " + i));
		}
	}

	// Supprime tout fond indésirable
	@Override
	protected void renderBackground(PoseStack poseStack) {
		// Désactiver le rendu de la dirt en fond
		setRenderBackground(false);
		setRenderTopAndBottom(false);
	}


	// To make content dont exit the scroll list's area
	@Override
	public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
		// Convertir les coordonnées pour le Scissor Test
		int scissorX = (int) (this.getLeft() * this.minecraft.getWindow().getGuiScale());
		int scissorY = (int) ((this.minecraft.getWindow().getGuiScaledHeight() - this.getBottom()) * this.minecraft.getWindow().getGuiScale());
		int scissorWidth = (int) (this.getWidth() * this.minecraft.getWindow().getGuiScale());
		int scissorHeight = (int) (this.getHeight() * this.minecraft.getWindow().getGuiScale());

		// Activer le Scissor Test
		RenderSystem.enableScissor(scissorX, scissorY, scissorWidth, scissorHeight);

		// Appeler la méthode parente pour dessiner la liste
		super.render(poseStack, mouseX, mouseY, partialTick);

		// Désactiver le Scissor Test après le rendu
		RenderSystem.disableScissor();
	}

	// Ajuste la largeur des éléments (pour les aligner avec la scrollbar)
	@Override
	public int getRowWidth() {
		return this.getWidth() - 12; // Largeur de la liste moins un décalage pour la scrollbar
	}

	// Ajuste la position de la scrollbar (pour être alignée à droite)
	@Override
	protected int getScrollbarPosition() {
		return this.getLeft() + this.getWidth() - 6; // Scrollbar 6 pixels à l'intérieur du bord droit
	}

	// Implémentation de la méthode obligatoire pour l'accessibilité
	@Override
	public void updateNarration(NarrationElementOutput narrationElementOutput) {
		// Implémentation vide pour l'instant
		// Si nécessaire, ajoute une description comme : narrationElementOutput.add(NarratedElementType.TITLE, "Description ici");
	}

	// Gestionnaire pour dessiner chaque entrée
	protected class Entry extends AbstractSelectionList.Entry<Entry> {
		private final String text;

		// Constructeur de l'entrée avec un texte à afficher
		public Entry(String text) {
			this.text = text;
		}

		/*// Supprime tout fond indésirable
		protected void renderBackground(PoseStack poseStack) {
			// Laisse vide pour ne rien dessiner en arrière-plan
			setRenderBackground(false);
			setRenderTopAndBottom(false);
		}*/

		@Override
		public void render(PoseStack poseStack, int index, int y, int x, int itemWidth, int itemHeight, int mouseX, int mouseY, boolean isSelected, float partialTick) {
			// Dessine un fond pour chaque élément (facultatif)
			fill(poseStack, x, y, x + itemWidth, y + itemHeight, isSelected ? 0xFFAAAAAA : 0xFF000000);

			// Dessine le texte, avec un léger décalage vers la droite
			Minecraft.getInstance().font.draw(poseStack, this.text, x + 10, y + 5, 0xFFFFFF);
		}

		@Override
		public boolean mouseClicked(double mouseX, double mouseY, int button) {
			System.out.println("Cliqué sur : " + this.text);
			return true;
		}
	}
}
