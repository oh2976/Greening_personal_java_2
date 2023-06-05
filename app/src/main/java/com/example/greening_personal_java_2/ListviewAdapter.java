package com.example.greening_personal_java_2;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    private ArrayList<Listviewitem> arrayList = new ArrayList<>();

    public ListviewAdapter(){

    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listviewitem, viewGroup, false);

        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        TextView text1 = (TextView) view.findViewById(R.id.txt_pname);
        TextView text2 = (TextView) view.findViewById(R.id.txt_pquan);
        TextView text3 = (TextView) view.findViewById(R.id.txt_pprice);

        Listviewitem listviewitem = arrayList.get(i);

        imageView.setImageDrawable(listviewitem.getDrawable());
        text1.setText(listviewitem.getText1());
        text2.setText(listviewitem.getText2());
        text3.setText(listviewitem.getText3());
        return view;
    }

    public void addItem(Drawable drawable, String text1, String text2, String text3){
        Listviewitem listviewitem = new Listviewitem();
        listviewitem.setDrawable(drawable);
        listviewitem.setText1(text1);
        listviewitem.setText2(text2);
        listviewitem.setText3(text3);

        arrayList.add(listviewitem);
    }
    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                float px = 500 * (listView.getResources().getDisplayMetrics().density);
                item.measure(View.MeasureSpec.makeMeasureSpec((int) px, View.MeasureSpec.AT_MOST), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);
            // Get padding
            int totalPadding = listView.getPaddingTop() + listView.getPaddingBottom();

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight + totalPadding;
            listView.setLayoutParams(params);
            listView.requestLayout();
            //setDynamicHeight(listView);
            return true;

        } else {
            return false;
        }
    }
}



