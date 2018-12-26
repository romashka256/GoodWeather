package goodweather.com.goodweather.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import goodweather.com.goodweather.R;
import goodweather.com.goodweather.model.models.WhyModel;
import goodweather.com.goodweather.presenter.listeners.OnQuestionsClicked;

public class WhyLikeThatAdapter extends BaseAdapter {

    Context context;
    OnQuestionsClicked listener;
    List<WhyModel> whyModels;


    public WhyLikeThatAdapter(Context context, List<WhyModel> whyModels, OnQuestionsClicked onQuestionsClicked) {
        this.whyModels = whyModels;
        this.context = context;
        listener = onQuestionsClicked;
    }

    @Override
    public int getCount() {
        return whyModels.size();
    }

    @Override
    public Object getItem(int position) {
        return whyModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.why_item, parent, false);
        WhyModel whyModel = whyModels.get(position);

        ((TextView) view.findViewById(R.id.why_text_item)).setText(whyModel.getAsk());

        view.setOnClickListener(v -> listener.OnClicked(position));

        return view;
    }
}
