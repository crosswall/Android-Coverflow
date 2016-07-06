package me.crosswall.coverflow.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by vincentpaing on 6/7/16.
 */
public class OverlapFragment extends Fragment {

  int resourceId;
  static final String ARG_RES_ID = "ARG_RES_ID";

  public static OverlapFragment newInstance(int resourceId) {
    OverlapFragment overlapFragment = new OverlapFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(ARG_RES_ID, resourceId);
    overlapFragment.setArguments(bundle);
    return overlapFragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    resourceId = getArguments().getInt(ARG_RES_ID);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.item_overlap_cover, container, false);
    ImageView coverImageView = (ImageView) rootView.findViewById(R.id.image_cover);
    coverImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), resourceId));
    return rootView;
  }
}
