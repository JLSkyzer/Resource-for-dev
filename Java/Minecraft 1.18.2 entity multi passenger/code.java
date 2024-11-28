   @Override
   public Entity getControllingPassenger() {
      return this.getFirstPassenger();
   }

    @Override
    public boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().size() < 4;
    }

    @Override
    public void positionRider(Entity passenger) {
        if (this.hasPassenger(passenger)) {
            //X is right to left
            //Y is down and up
            //Z is front to back
            //Passenger 0 offsets
            double p0offX = 0F;
            double p0offY = 0F;
            double p0offZ = 0F;
            //Passenger 1 offsets
            double p1offX = 2F;
            double p1offY = 0F;
            double p1offZ = 0F;
            //Passenger 2 offsets
            double p2offX = 0F;
            double p2offY = 0F;
            double p2offZ = 2F;
            //Passenger 3 offsets
            double p3offX = 2F;
            double p3offY = 0F;
            double p3offZ = 2F;
            //Reading passenger offsets and applying them
            Vec3 passenger0offset = (new Vec3(p0offX, p0offY, p0offZ)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            Vec3 passenger1offset = (new Vec3(p1offX, p1offY, p1offZ)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            Vec3 passenger2offset = (new Vec3(p2offX, p2offY, p2offZ)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            Vec3 passenger3offset = (new Vec3(p3offX, p3offY, p3offZ)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
            int passengerNumber = this.getPassengers().indexOf(passenger);
            if (passengerNumber == 0) {
                passenger.setPos(this.getX() + passenger0offset.x, this.getY() + passenger0offset.y, this.getZ() + passenger0offset.z);
            }
            if (passengerNumber == 1) {
                passenger.setPos(this.getX() + passenger1offset.x, this.getY() + passenger1offset.y, this.getZ() + passenger1offset.z);
            }
            if (passengerNumber == 2) {
                passenger.setPos(this.getX() + passenger2offset.x, this.getY() + passenger2offset.y, this.getZ() + passenger2offset.z);
            }
            if (passengerNumber == 3) {
                passenger.setPos(this.getX() + passenger3offset.x, this.getY() + passenger3offset.y, this.getZ() + passenger3offset.z);
            }

        }
    }