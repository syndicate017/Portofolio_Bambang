package io.github.syndicate017.portofoliobambang.portofolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.syndicate017.portofoliobambang.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PortofolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortofolioFragment extends Fragment implements PortofolioCallback{

    List<PortofolioItem> mdata;
    RecyclerView rv_portofolio;
    PortofolioAdapter portofolioAdapter;

    public PortofolioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portofolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portofolio = view.findViewById(R.id.rv_portofolio);

        //Create a list of portofolio items
        mdata = new ArrayList<>();
        mdata.add(new PortofolioItem(R.drawable.tictactoe, "Tic Tac Toe", getString(R.string.tictactoe)));
        mdata.add(new PortofolioItem(R.drawable.media, "Media Demo", getString(R.string.media_demo)));
        mdata.add(new PortofolioItem(R.drawable.flag, "Flag Anthem", getString(R.string.flag_anthem)));
        mdata.add(new PortofolioItem(R.drawable.hanoi, "Tower of Hanoi", getString(R.string.tower_of_hanoi)));
        mdata.add(new PortofolioItem(R.drawable.sierpinski, "Sierpinski Triangle", getString(R.string.sierpinski_triangle)));
        mdata.add(new PortofolioItem(R.drawable.count_occurence, "Count Occurrence of Words Stream", getString(R.string.count_occurrence)));
        mdata.add(new PortofolioItem(R.drawable.new_row, "New Row Demo", getString(R.string.new_row)));
        mdata.add(new PortofolioItem(R.drawable.world_clock, "World Clock", getString(R.string.world_clock)));
        mdata.add(new PortofolioItem(R.drawable.calendar, "Calendar", getString(R.string.calendar)));

        portofolioAdapter = new PortofolioAdapter(mdata, this);

        //Set up grid recycle view
        rv_portofolio.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rv_portofolio.setAdapter(portofolioAdapter);
    }

    @Override
    public void onPortofolioItemClick(int pos) {

        //Handle click listener event when portofolio item clicked
        //First we need to create a fragment bottom sheet instance

        PortofolioFragmentDetails portofolioFragmentDetails = new PortofolioFragmentDetails();

        //Now we need to send portofolio item to portofolio dialog fragment
        //We will use bundle for that
        //Also we need our portofolio item data class to implement serializable interface so we can send it

        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portofolioFragmentDetails.setArguments(bundle);

        //Now let's open the portofolio bottom sheet fragment
        portofolioFragmentDetails.show(getActivity().getSupportFragmentManager(), "tagname");

        //Now we done opening the bottom sheet
        //Let's test it out
    }
}