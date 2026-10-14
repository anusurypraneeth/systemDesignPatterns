// ── 1. COMPONENT (abstract base) ──────────────────────────
abstract class ICharacter {
    public abstract String getAbilities();
}

// ── 2. CONCRETE COMPONENT ─────────────────────────────────
class Maria extends ICharacter {
    @Override
    public String getAbilities() {
        return "Maria: [Base abilities]";
    }
}

// ── 3. ABSTRACT DECORATOR (has-a ICharacter) ──────────────
abstract class Decorator extends ICharacter {
    protected ICharacter ch;          // has-a relationship

    public Decorator(ICharacter ch) {
        this.ch = ch;
    }

    @Override
    public abstract String getAbilities();
}

// ── 4. CONCRETE DECORATORS ────────────────────────────────
class HeightUpDec extends Decorator {
    public HeightUpDec(ICharacter ch) {
        super(ch);
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + " + HeightUp";
    }
}

class GunFlowerDec extends Decorator {
    public GunFlowerDec(ICharacter ch) {
        super(ch);
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + " + GunFlower";
    }
}

class StarFlowerDec extends Decorator {
    public StarFlowerDec(ICharacter ch) {
        super(ch);
    }

    @Override
    public String getAbilities() {
        return ch.getAbilities() + " + StarFlower";
    }
}

// ── 5. MAIN ───────────────────────────────────────────────
public class DecoratorDemo {
    public static void main(String[] args) {

        ICharacter mario = new Maria();
        System.out.println(mario.getAbilities());
        // Maria: [Base abilities]

        ICharacter withHeight = new HeightUpDec(mario);
        System.out.println(withHeight.getAbilities());
        // Maria: [Base abilities] + HeightUp

        ICharacter withGun = new GunFlowerDec(withHeight);
        System.out.println(withGun.getAbilities());
        // Maria: [Base abilities] + HeightUp + GunFlower

        ICharacter fullyPowered = new StarFlowerDec(withGun);
        System.out.println(fullyPowered.getAbilities());
        // Maria: [Base abilities] + HeightUp + GunFlower + StarFlower
    }
}