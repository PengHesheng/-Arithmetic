package designmodel.builder;

/**
 * @author 14512 on 2019/3/30.
 */
public abstract class Builder {
    public abstract Builder buildBoard(String board);

    public abstract Builder buildDisplay(String display);

    public abstract Builder buildOS();

    public abstract Computer create();
}
