package cl.fundacionprotesis3d.mytestone;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class DonateFragment extends Fragment {


    public DonateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donate, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SeekBar donationSb = (SeekBar) view.findViewById(R.id.donationSb);
        final TextView donationTv = (TextView) view.findViewById(R.id.donationTv);
        Button donationBtn = (Button) view.findViewById(R.id.donationBtn);

        donationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                donationTv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        donationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int donation = donationSb.getProgress();
                if(donation < 10000){
                    Toast.makeText(getContext(), "¡GRACIAS POR TU DONACIÓN!", Toast.LENGTH_SHORT).show();
                }else if( (donation >= 10000) && (donation <30000)){
                    Toast.makeText(getContext(), "¡WOW! ¡ERES GENIAL!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(), "¡NO SABEMOS CÓMO AGRADECERTE! ¡TE CONTACTAREMOS!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
