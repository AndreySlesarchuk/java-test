package by.atmm.__gof.structural;

public class DecoratorChristmasTree {
    public static void main(String[] args) {
        ChristmasTree tree1 = new BubbleLights(new Garland(new ChristmasTreeImpl()));
        System.out.println(tree1.decorate());
    }
}

interface ChristmasTree {
    String decorate();
}

class ChristmasTreeImpl implements ChristmasTree {
    @Override
    public String decorate() {
        return "Christmas tree";
    }
}

abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    protected TreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    // standard constructors
    @Override
    public String decorate() {
        return tree.decorate();
    }
}

class BubbleLights extends TreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}

class Garland extends TreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithGarland();
    }

    private String decorateWithGarland() {
        return " with Garland";
    }
}