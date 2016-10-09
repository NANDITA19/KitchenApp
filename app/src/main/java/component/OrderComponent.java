package component;

/**
 * Created by rutvik on 9/18/2016 at 2:28 PM.
 */

public class OrderComponent<T>
{

    public static final int SIMPLE_ORDER = 0;

    private final T model;

    private final int viewType;

    public OrderComponent(final T model, final int viewType)
    {
        this.model = model;
        this.viewType = viewType;
    }

    public int getViewType()
    {
        return viewType;
    }

    public T getModel()
    {
        return model;
    }


}
