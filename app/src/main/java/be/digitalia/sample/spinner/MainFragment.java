package be.digitalia.sample.spinner;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainFragment extends Fragment {

	private static final int VALUES_COUNT = 10;

	private ArrayAdapter<String> adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
		adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);

		return view;
	}

	@Override
	public void onDestroyView() {
		adapter = null;
		super.onDestroyView();
	}

	@Override
	public void onStart() {
		super.onStart();
		populateAdapter();
	}

	void populateAdapter() {
		String[] values = new String[VALUES_COUNT];
		for (int i = 0; i < VALUES_COUNT; i++) {
			values[i] = "Item " + (i + 1);
		}
		adapter.clear();
		adapter.addAll(values);
	}
}
