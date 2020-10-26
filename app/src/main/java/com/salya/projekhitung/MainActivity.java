package com.salya.projekhitung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText salyanilaikehadiran, salyanilaitugas, salyanilaiuts, salyanilaiuas;
    Button salyabtnhitung;
    TextView salyatxtakhir,salyatxtket;
    double salyajumlahkehadiran, salyahasiltugas, salyahasiluts, salyahasiluas, salyahasilhitung;
    String  ket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salyanilaikehadiran = findViewById(R.id.nilai_kehadiran);
        salyanilaitugas = findViewById(R.id.nilai_tugas);
        salyanilaiuts = findViewById(R.id.nilai_uts);
        salyanilaiuas = findViewById(R.id.nilai_uas);
        salyabtnhitung = findViewById(R.id.btn_hitung);
        salyatxtket = findViewById(R.id.txt_ket);
        salyatxtakhir = findViewById(R.id.txt_nilaiakhir);
    }

    @Override
    public void onClick(View v) {
        if (salyanilaikehadiran.getText().length() == 0) {
            Toast.makeText(this, "Nilai Kehadiran masih kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (salyanilaitugas.getText().length() == 0) {
            Toast.makeText(this, "Nilai Tugas masih kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (salyanilaiuts.getText().length() == 0) {
            Toast.makeText(this, "Nilai uts masih kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (salyanilaiuas.getText().length() == 0) {
            Toast.makeText(this, "Nilai uas masih kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        salyajumlahkehadiran = Double.parseDouble(salyanilaikehadiran.getText().toString());
        salyahasiltugas = Double.parseDouble(salyanilaitugas.getText().toString());
        salyahasiluts = Double.parseDouble(salyanilaiuts.getText().toString());
        salyahasiluas = Double.parseDouble(salyanilaiuas.getText().toString());
        salyahasilhitung = (salyajumlahkehadiran*0.1 + salyahasiltugas*0.35 + salyahasiluts*0.2 + salyahasiluas*0.35);

        salyabtnhitung.setOnClickListener(v1 -> {
            salyatxtakhir.setText(String.valueOf(salyahasilhitung));
            if (salyahasilhitung >= 70 ){
                ket = "LULUS";
            }else {
                ket = "TIDAK LULUS";
            }
            salyatxtket.setText(ket);
        });




    }
}