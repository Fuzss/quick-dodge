package fuzs.quickdodge.common.attachment;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.ints.IntSets;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.Nullable;

public record DodgeData(int remainingDodgeTicks, IntSet bashedEntityIds, @Nullable AABB originalBoundingBox) {
    public static final DodgeData DEFAULT = new DodgeData(0, IntSets.emptySet(), null);

    public DodgeData {
        bashedEntityIds = IntSets.unmodifiable(new IntOpenHashSet(bashedEntityIds));
    }

    public boolean isDodging() {
        return this.remainingDodgeTicks > 0;
    }

    public Mutable mutable() {
        return new Mutable(this);
    }

    public static class Mutable {
        private int remainingDodgeTicks;
        private final IntOpenHashSet bashedEntityIds;
        private AABB originalBoundingBox;

        public Mutable(DodgeData dodgeData) {
            this.remainingDodgeTicks = dodgeData.remainingDodgeTicks();
            this.bashedEntityIds = new IntOpenHashSet(dodgeData.bashedEntityIds());
            this.originalBoundingBox = dodgeData.originalBoundingBox();
        }

        public int getRemainingDodgeTicks() {
            return this.remainingDodgeTicks;
        }

        public void setRemainingDodgeTicks(int remainingDodgeTicks) {
            this.remainingDodgeTicks = remainingDodgeTicks;
        }

        public void decrementRemainingDodgeTicks() {
            this.remainingDodgeTicks--;
        }

        public IntSet bashedEntityIds() {
            return this.bashedEntityIds;
        }

        public void addBashedEntityId(int entityId) {
            this.bashedEntityIds.add(entityId);
        }

        public void clearBashedEntityIds() {
            this.bashedEntityIds.clear();
        }

        public AABB getOriginalBoundingBox() {
            return this.originalBoundingBox;
        }

        public void setOriginalBoundingBox(@Nullable AABB originalBoundingBox) {
            this.originalBoundingBox = originalBoundingBox;
        }

        public DodgeData toImmutable() {
            return new DodgeData(this.remainingDodgeTicks, this.bashedEntityIds, this.originalBoundingBox);
        }
    }
}
