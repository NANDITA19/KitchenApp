package viewcomponent;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import component.OrderComponent;
import io.fusionbit.kitchenapp.R;
import model.MenuItem;
import model.Order;

/**
 * Created by rutvik on 9/18/2016 at 4:10 PM.
 */

public class MenuItemTV extends RelativeLayout
{

    private final String text;

    private int status, quantity;

    private TextView tvItemQuantity, tvItemName;

    private ImageView ivItemStatus;

    private Context context;

    public MenuItemTV(Context context, final String text, final int status, int quantity)
    {
        super(context);
        this.context = context;
        this.text = text;
        this.status = status;
        this.quantity = quantity;

        final View view = LayoutInflater.from(context).inflate(R.layout.view_menu_item, this, true);

        tvItemQuantity = (TextView) view.findViewById(R.id.tv_itemQuantity);
        tvItemName = (TextView) view.findViewById(R.id.tv_itemName);
        ivItemStatus = (ImageView) view.findViewById(R.id.iv_itemStatus);

        tvItemName.setText(text);
        setQuantity(quantity);
        setItemStatus(status);

    }

    public void setItemStatus(int status)
    {
        /**FRESH(0),
        COOKING(1),
        READY(2),
        SERVED(3),
        CANCELED(-1);*/

        if (status == 0)
        {

        } else if (status == 1)
        {

        } else if (status == 2)
        {

        } else if (status == 3)
        {

        } else if (status == -1)
        {
            tvItemName.setPaintFlags(tvItemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
        tvItemQuantity.setText(String.valueOf(quantity));
    }


}
