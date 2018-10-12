package com.wiser.slidingmenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ContentFragment extends Fragment {

	private RecyclerView rlvList;

	@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.content_frg, container, false);
		rlvList = view.findViewById(R.id.rlv_list);
		rlvList.setLayoutManager(new LinearLayoutManager(getActivity()));
		rlvList.setAdapter(new MAdapter());
		return view;
	}

	private class MAdapter extends RecyclerView.Adapter<MHolder> {

		@NonNull @Override public MHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
			return new MHolder(LayoutInflater.from(getActivity()).inflate(R.layout.content_item, viewGroup, false));
		}

		@Override public void onBindViewHolder(@NonNull MHolder mHolder, int i) {

		}

		@Override public int getItemCount() {
			return 100;
		}
	}

	private class MHolder extends RecyclerView.ViewHolder {

		public MHolder(@NonNull View itemView) {
			super(itemView);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Toast.makeText(getActivity(),"哈哈哈",Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
