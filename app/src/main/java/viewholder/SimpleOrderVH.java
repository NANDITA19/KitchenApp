package viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.fusionbit.kitchenapp.R;
import model.MenuItem;
import model.Order;
import viewcomponent.MenuItemTV;

/**
 * Created by rutvik on 9/18/2016 at 3:13 PM.
 */

public class SimpleOrderVH extends RecyclerView.ViewHolder
{

    LinearLayout llOrderItem;

    TextView tvOrderName, tvTimestamp, tvOrderTakenBy, tvTotalPrice;

    List<MenuItemTV> menuItemTVList = new ArrayList<>();

    final Context context;

    Order model;

    private SimpleOrderVH(Context context, View itemView)
    {
        super(itemView);
        this.context = context;

        llOrderItem = (LinearLayout) itemView.findViewById(R.id.ll_orderItem);
        tvOrderName = (TextView) itemView.findViewById(R.id.tv_orderName);
        tvTimestamp = (TextView) itemView.findViewById(R.id.tv_timestamp);
        tvOrderTakenBy = (TextView) itemView.findViewById(R.id.tv_orderTakenBy);
        tvTotalPrice = (TextView) itemView.findViewById(R.id.tv_totalPrice);
    }

    public static SimpleOrderVH create(final Context context, final ViewGroup parent)
    {
        SimpleOrderVH vh = new SimpleOrderVH(context, LayoutInflater.from(context)
                .inflate(R.layout.single_simple_order_row_item, parent, false));

        return vh;
    }

    public static void bind(SimpleOrderVH vh, Order model)
    {

        vh.model = model;

        vh.tvOrderName.setText(model.getOrderName());
        vh.tvOrderTakenBy.setText(model.getUserDisplayName());
        vh.tvTimestamp.setText(String.valueOf(model.getOrderTime()));

        vh.llOrderItem.removeAllViews();
        for (MenuItem menuItem : vh.model.getMenuItemList())
        {
            vh.llOrderItem
                    .addView(new MenuItemTV(vh.context, menuItem.getName(), menuItem.getStatus(),
                            menuItem.getQuantity()));
        }

        vh.tvTotalPrice.setText(vh.context.getResources().getString(R.string.rs) + model.getTotalPrice());

    }

}
