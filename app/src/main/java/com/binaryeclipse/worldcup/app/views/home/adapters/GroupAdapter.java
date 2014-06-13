package com.binaryeclipse.worldcup.app.views.home.adapters;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.binaryeclipse.worldcup.app.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Andras on 2014/06/12.
 */
public class GroupAdapter extends BaseExpandableListAdapter {

    private final List<List<String>> children;
    private final Context context;
//    private final List<String> headers;

    public GroupAdapter(Context context, /*List<String> headers, */List<List<String>> children) {
        this.context = context;
//        this.headers = headers;
        this.children = children;

    }

    @Override
    public int getGroupCount() {
        return children.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<String> group = getGroup(groupPosition);
        if (group != null) {
            return group.size();
        }
        return 0;
    }

    @Override
    public List<String> getGroup(int groupPosition) {
        int index = 0;
        for (List<String> list : children) {
            if (index == groupPosition) {
                return list;
            }
            index++;
        }
        return null;
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        List<String> group = getGroup(groupPosition);
        if (group != null) {
            return group.get(childPosition);
        }
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return -1;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return -1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (GroupViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.group_view, null);
            viewHolder = new GroupViewHolder(convertView);
        }
        viewHolder.groupIdentifier.setText(getGroupName(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ChildViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.child_view, null);
            viewHolder = new ChildViewHolder(convertView);
        }
        viewHolder.childIdentifier.setText(getChild(groupPosition, childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class GroupViewHolder {
        @InjectView(R.id.group_view_identifier)
        public TextView groupIdentifier;

        public GroupViewHolder(View view) {
            view.setTag(this);
            ButterKnife.inject(this, view);
        }
    }

    public class ChildViewHolder {
        @InjectView(R.id.child_view_identifier)
        public TextView childIdentifier;

        public ChildViewHolder(View view) {
            view.setTag(this);
            ButterKnife.inject(this, view);
        }
    }

    private String getGroupName(int groupPosition) {
        int value = (int)('A') + groupPosition;
        char c = (char) value;
        return c+"";
    }
}
