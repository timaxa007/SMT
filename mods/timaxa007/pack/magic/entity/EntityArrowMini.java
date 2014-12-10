package mods.timaxa007.pack.magic.entity;

import java.util.List;

import mods.timaxa007.pack.magic.PackMagic;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityArrowMini extends Entity implements IProjectile {

private int xTile = -1;
private int yTile = -1;
private int zTile = -1;
private int inTile;
private int inData;
private boolean inGround;
public int canBePickedUp;
public int arrowShake;
public Entity shootingEntity;
private int ticksInGround;
private int ticksInAir;
private double damage = 2.0D;
private int knockbackStrength;

public EntityArrowMini(World world) {
super(world);
renderDistanceWeight = 10.0D;
setSize(0.5F, 0.5F);
}

public EntityArrowMini(World world, double par2, double par4, double par6) {
super(world);
renderDistanceWeight = 10.0D;
setSize(0.5F, 0.5F);
setPosition(par2, par4, par6);
yOffset = 0.0F;
}

public EntityArrowMini(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5) {
super(par1World);
renderDistanceWeight = 10.0D;
shootingEntity = par2EntityLivingBase;

if (par2EntityLivingBase instanceof EntityPlayer) {
canBePickedUp = 1;
}

posY = par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight() - 0.10000000149011612D;
double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
double d1 = par3EntityLivingBase.boundingBox.minY + (double)(par3EntityLivingBase.height / 3.0F) - posY;
double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);

if (d3 >= 1.0E-7D) {
float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
double d4 = d0 / d3;
double d5 = d2 / d3;
setLocationAndAngles(par2EntityLivingBase.posX + d4, posY, par2EntityLivingBase.posZ + d5, f2, f3);
yOffset = 0.0F;
float f4 = (float)d3 * 0.2F;
setThrowableHeading(d0, d1 + (double)f4, d2, par4, par5);
}
}

public EntityArrowMini(World world, EntityLivingBase par2EntityLivingBase, float par3) {
super(world);
renderDistanceWeight = 10.0D;
shootingEntity = par2EntityLivingBase;

if (par2EntityLivingBase instanceof EntityPlayer) {
canBePickedUp = 1;
}

setSize(0.5F, 0.5F);
setLocationAndAngles(par2EntityLivingBase.posX, par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight(), par2EntityLivingBase.posZ, par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
posX -= (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
posY -= 0.10000000149011612D;
posZ -= (double)(MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
setPosition(posX, posY, posZ);
yOffset = 0.0F;
motionX = (double)(-MathHelper.sin(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI));
motionZ = (double)(MathHelper.cos(rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(rotationPitch / 180.0F * (float)Math.PI));
motionY = (double)(-MathHelper.sin(rotationPitch / 180.0F * (float)Math.PI));
setThrowableHeading(motionX, motionY, motionZ, par3 * 1.5F, 1.0F);
}

@Override
protected void entityInit() {
dataWatcher.addObject(16, Byte.valueOf((byte)0));
}

public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
setPosition(par1, par3, par5);
setRotation(par7, par8);
}

@SideOnly(Side.CLIENT)
public void setVelocity(double par1, double par3, double par5) {
motionX = par1;
motionY = par3;
motionZ = par5;

if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F) {
float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
prevRotationYaw = rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
prevRotationPitch = rotationPitch = (float)(Math.atan2(par3, (double)f) * 180.0D / Math.PI);
prevRotationPitch = rotationPitch;
prevRotationYaw = rotationYaw;
setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
ticksInGround = 0;
}
}

public void onUpdate() {
super.onUpdate();

if (prevRotationPitch == 0.0F && prevRotationYaw == 0.0F) {
float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
prevRotationYaw = rotationYaw = (float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
prevRotationPitch = rotationPitch = (float)(Math.atan2(motionY, (double)f) * 180.0D / Math.PI);
}

int i = worldObj.getBlock(xTile, yTile, zTile);

if (i > 0) {
Block.blocksList[i].setBlockBoundsBasedOnState(worldObj, xTile, yTile, zTile);
AxisAlignedBB axisalignedbb = Block.blocksList[i].getCollisionBoundingBoxFromPool(worldObj, xTile, yTile, zTile);

if (axisalignedbb != null && axisalignedbb.isVecInside(worldObj.getWorldVec3Pool().getVecFromPool(posX, posY, posZ))) {
inGround = true;
}
}

if (arrowShake > 0) {--arrowShake;}

if (inGround) {
int j = worldObj.getBlock(xTile, yTile, zTile);
int k = worldObj.getBlockMetadata(xTile, yTile, zTile);

if (j == inTile && k == inData) {
++ticksInGround;

if (ticksInGround == 1200) {
setDead();
}
} else {
inGround = false;
motionX *= (double)(rand.nextFloat() * 0.2F);
motionY *= (double)(rand.nextFloat() * 0.2F);
motionZ *= (double)(rand.nextFloat() * 0.2F);
ticksInGround = 0;
ticksInAir = 0;
}
} else {
++ticksInAir;
Vec3 vec3 = worldObj.getWorldVec3Pool().getVecFromPool(posX, posY, posZ);
Vec3 vec31 = worldObj.getWorldVec3Pool().getVecFromPool(posX + motionX, posY + motionY, posZ + motionZ);
MovingObjectPosition movingobjectposition = worldObj.rayTraceBlocks_do_do(vec3, vec31, false, true);
vec3 = worldObj.getWorldVec3Pool().getVecFromPool(posX, posY, posZ);
vec31 = worldObj.getWorldVec3Pool().getVecFromPool(posX + motionX, posY + motionY, posZ + motionZ);

if (movingobjectposition != null) {
vec31 = worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
}

Entity entity = null;
List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
double d0 = 0.0D;
int l;
float f1;

for (l = 0; l < list.size(); ++l) {
Entity entity1 = (Entity)list.get(l);

if (entity1.canBeCollidedWith() && (entity1 != shootingEntity || ticksInAir >= 5)) {
f1 = 0.3F;
AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);

if (movingobjectposition1 != null) {
double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

if (d1 < d0 || d0 == 0.0D) {
entity = entity1;
d0 = d1;
}
}
}
}

if (entity != null) {
movingobjectposition = new MovingObjectPosition(entity);
}

if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer) {
EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;

if (entityplayer.capabilities.disableDamage || shootingEntity instanceof EntityPlayer && !((EntityPlayer)shootingEntity).canAttackPlayer(entityplayer)) {
movingobjectposition = null;
}
}

float f2;
float f3;

if (movingobjectposition != null) {
if (movingobjectposition.entityHit != null) {
f2 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
int i1 = MathHelper.ceiling_double_int((double)f2 * damage);

if (getIsCritical()) {
i1 += rand.nextInt(i1 / 2 + 2);
}

DamageSource damagesource = null;

if (shootingEntity == null) {
damagesource = (new EntityDamageSourceIndirect("arrowMini", this, this)).setProjectile();
} else {
damagesource = (new EntityDamageSourceIndirect("arrowMini", this, shootingEntity)).setProjectile();
}

if (isBurning() && !(movingobjectposition.entityHit instanceof EntityEnderman)) {
movingobjectposition.entityHit.setFire(5);
}

if (movingobjectposition.entityHit.attackEntityFrom(damagesource, (float)i1)) {
if (movingobjectposition.entityHit instanceof EntityLivingBase) {
EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;

if (!worldObj.isRemote) {
entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
}

if (knockbackStrength > 0) {
f3 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);

if (f3 > 0.0F) {
movingobjectposition.entityHit.addVelocity(motionX * (double)knockbackStrength * 0.6000000238418579D / (double)f3, 0.1D, motionZ * (double)knockbackStrength * 0.6000000238418579D / (double)f3);
}
}

if (shootingEntity != null) {
EnchantmentThorns.func_92096_a(shootingEntity, entitylivingbase, rand);
}

if (shootingEntity != null && movingobjectposition.entityHit != shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && shootingEntity instanceof EntityPlayerMP) {
((EntityPlayerMP)shootingEntity).playerNetServerHandler.sendPacketToPlayer(new Packet70GameEvent(6, 0));
}
}

playSound("random.bowhit", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));

if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
setDead();
}
} else {
motionX *= -0.10000000149011612D;
motionY *= -0.10000000149011612D;
motionZ *= -0.10000000149011612D;
rotationYaw += 180.0F;
prevRotationYaw += 180.0F;
ticksInAir = 0;
}
} else {
xTile = movingobjectposition.blockX;
yTile = movingobjectposition.blockY;
zTile = movingobjectposition.blockZ;
inTile = worldObj.getBlock(xTile, yTile, zTile);
inData = worldObj.getBlockMetadata(xTile, yTile, zTile);
motionX = (double)((float)(movingobjectposition.hitVec.xCoord - posX));
motionY = (double)((float)(movingobjectposition.hitVec.yCoord - posY));
motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - posZ));
f2 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
posX -= motionX / (double)f2 * 0.05000000074505806D;
posY -= motionY / (double)f2 * 0.05000000074505806D;
posZ -= motionZ / (double)f2 * 0.05000000074505806D;
playSound("random.bowhit", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
inGround = true;
arrowShake = 7;
setIsCritical(false);

if (inTile != 0)
{
Block.blocksList[inTile].onEntityCollidedWithBlock(worldObj, xTile, yTile, zTile, this);
}
}
}

if (getIsCritical())
{
for (l = 0; l < 4; ++l)
{
worldObj.spawnParticle("crit", posX + motionX * (double)l / 4.0D, posY + motionY * (double)l / 4.0D, posZ + motionZ * (double)l / 4.0D, -motionX, -motionY + 0.2D, -motionZ);
}
}

posX += motionX;
posY += motionY;
posZ += motionZ;
f2 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
rotationYaw = (float)(Math.atan2(motionX, motionZ) * 180.0D / Math.PI);

for (rotationPitch = (float)(Math.atan2(motionY, (double)f2) * 180.0D / Math.PI); rotationPitch - prevRotationPitch < -180.0F; prevRotationPitch -= 360.0F)
{
;
}

while (rotationPitch - prevRotationPitch >= 180.0F) {
prevRotationPitch += 360.0F;
}

while (rotationYaw - prevRotationYaw < -180.0F) {
prevRotationYaw -= 360.0F;
}

while (rotationYaw - prevRotationYaw >= 180.0F) {
prevRotationYaw += 360.0F;
}

rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
float f4 = 0.99F;
f1 = 0.05F;

if (isInWater())
{
for (int j1 = 0; j1 < 4; ++j1)
{
f3 = 0.25F;
worldObj.spawnParticle("bubble", posX - motionX * (double)f3, posY - motionY * (double)f3, posZ - motionZ * (double)f3, motionX, motionY, motionZ);
}

f4 = 0.8F;
}

motionX *= (double)f4;
motionY *= (double)f4;
motionZ *= (double)f4;
motionY -= (double)f1;
setPosition(posX, posY, posZ);
doBlockCollisions();
}
}

@Override
protected void readEntityFromNBT(NBTTagCompound nbt) {
xTile = nbt.getShort("xTile");
yTile = nbt.getShort("yTile");
zTile = nbt.getShort("zTile");
inTile = nbt.getByte("inTile") & 255;
inData = nbt.getByte("inData") & 255;
arrowShake = nbt.getByte("shake") & 255;
inGround = nbt.getByte("inGround") == 1;

if (nbt.hasKey("damage")) {
damage = nbt.getDouble("damage");
}

if (nbt.hasKey("pickup"))
{
canBePickedUp = nbt.getByte("pickup");
}
else if (nbt.hasKey("player"))
{
canBePickedUp = nbt.getBoolean("player") ? 1 : 0;
}
}

@Override
protected void writeEntityToNBT(NBTTagCompound nbt) {
nbt.setShort("xTile", (short)xTile);
nbt.setShort("yTile", (short)yTile);
nbt.setShort("zTile", (short)zTile);
nbt.setByte("inTile", (byte)inTile);
nbt.setByte("inData", (byte)inData);
nbt.setByte("shake", (byte)arrowShake);
nbt.setByte("inGround", (byte)(inGround ? 1 : 0));
nbt.setByte("pickup", (byte)canBePickedUp);
nbt.setDouble("damage", damage);
}

/**
 * Called by a player entity when they collide with an entity
 */
public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
{
if (!worldObj.isRemote && inGround && arrowShake <= 0)
{
boolean flag = canBePickedUp == 1 || canBePickedUp == 2 && par1EntityPlayer.capabilities.isCreativeMode;

if (canBePickedUp == 1 && !par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(PackMagic.proxy.itemArrowMini, 1)))
{
flag = false;
}

if (flag)
{
playSound("random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
par1EntityPlayer.onItemPickup(this, 1);
setDead();
}
}
}

protected boolean canTriggerWalking() {return false;}

@SideOnly(Side.CLIENT)
public float getShadowSize() {return 0.0F;}

public void setDamage(double par1) {damage = par1;}

public double getDamage() {return damage;}

public void setKnockbackStrength(int par1) {knockbackStrength = par1;}

public boolean canAttackWithItem() {return false;}

public void setIsCritical(boolean par1) {
byte b0 = dataWatcher.getWatchableObjectByte(16);
if (par1) {
dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
} else {
dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
}
}

public boolean getIsCritical() {
byte b0 = dataWatcher.getWatchableObjectByte(16);
return (b0 & 1) != 0;
}

@Override
public void setThrowableHeading(double d0, double d1, double d2, float f, float f1) {
float f2 = MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
d0 /= (double)f2;
d1 /= (double)f2;
d2 /= (double)f2;
d0 += rand.nextGaussian() * (double)(rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)f1;
d1 += rand.nextGaussian() * (double)(rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)f1;
d2 += rand.nextGaussian() * (double)(rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)f1;
d0 *= (double)f;
d1 *= (double)f;
d2 *= (double)f;
motionX = d0;
motionY = d1;
motionZ = d2;
float f3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
prevRotationYaw = rotationYaw = (float)(Math.atan2(d0, d2) * 180.0D / Math.PI);
prevRotationPitch = rotationPitch = (float)(Math.atan2(d1, (double)f3) * 180.0D / Math.PI);
ticksInGround = 0;
}

}
