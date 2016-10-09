package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import component.OrderComponent;
import model.Order;
import viewholder.SimpleOrderVH;

/**
 * Created by rutvik on 9/18/2016 at 2:37 PM.
 */

public class OrderAdapter extends RecyclerView.Adapter
{

    List<OrderComponent> orderComponentList;

    final Context context;

    public OrderAdapter(final Context context)
    {
        orderComponentList = new ArrayList<>();
        this.context = context;
    }

    public void addOrder(Order order)
    {
        orderComponentList.add(new OrderComponent(order, OrderComponent.SIMPLE_ORDER));
        notifyItemInserted(orderComponentList.size());
    }

    @Override
    public int getItemViewType(int position)
    {
        return orderComponentList.get(position).getViewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        switch (viewType)
        {

            case OrderComponent.SIMPLE_ORDER:
                return SimpleOrderVH.create(context, parent);

            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        switch (getItemViewType(position))
        {

            case OrderComponent.SIMPLE_ORDER:
                SimpleOrderVH.bind((SimpleOrderVH) holder,
                        (Order) orderComponentList.get(position).getModel());
                break;

        }
    }

    @Override
    public int getItemCount()
    {
        return orderComponentList.size();
    }
}
