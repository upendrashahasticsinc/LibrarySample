package com.astics.mylibrary;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

/**
 * Created by Upendra Shah on 01 August, 2019 for
 * Project : AavGo-Guest-Android
 * Company : Astics Techlabs Pvt. Ltd
 * Email : upendra.shah@asticsinc.com
 **/
public class ExpandableListViewEmptySupport extends ExpandableListView {
    private View emptyView;

    public ExpandableListViewEmptySupport(Context context) {
        super(context);
    }

    public ExpandableListViewEmptySupport(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandableListViewEmptySupport(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(ExpandableListAdapter adapter) {
        super.setAdapter(adapter);

        if (adapter != null) {
            adapter.registerDataSetObserver(emptyObserver);
        }
        emptyObserver.onChanged();
    }

    private DataSetObserver emptyObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            ExpandableListAdapter adapter = getExpandableListAdapter();
            if (adapter != null && emptyView != null) {
                if (adapter.getGroupCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    ExpandableListViewEmptySupport.this.setVisibility(View.GONE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    ExpandableListViewEmptySupport.this.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    public void setEmptyView(View emptyView) {
        this.emptyView = emptyView;
    }
}
