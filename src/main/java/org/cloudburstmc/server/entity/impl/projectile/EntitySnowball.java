package org.cloudburstmc.server.entity.impl.projectile;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.projectile.Snowball;
import org.cloudburstmc.server.level.Location;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class EntitySnowball extends EntityProjectile implements Snowball {

    public EntitySnowball(EntityType<Snowball> type, Location location) {
        super(type, location);
    }

    @Override
    public float getWidth() {
        return 0.25f;
    }

    @Override
    public float getLength() {
        return 0.25f;
    }

    @Override
    public float getHeight() {
        return 0.25f;
    }

    @Override
    public float getGravity() {
        return 0.03f;
    }

    @Override
    public float getDrag() {
        return 0.01f;
    }

    @Override
    public boolean onUpdate(int currentTick) {
        if (this.closed) {
            return false;
        }

        this.timing.startTiming();

        boolean hasUpdate = super.onUpdate(currentTick);

        if (this.age > 1200 || this.isCollided) {
            this.kill();
            hasUpdate = true;
        }

        this.timing.stopTiming();

        return hasUpdate;
    }
}
