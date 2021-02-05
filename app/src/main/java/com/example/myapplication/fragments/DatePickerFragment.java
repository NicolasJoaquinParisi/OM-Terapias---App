package com.example.myapplication.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import com.example.myapplication.activities.ModificarTurnoActivity;
import com.example.myapplication.activities.NuevoTurnoActivity;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public static NuevoTurnoActivity nuevoTurnoActivity;
    public static ModificarTurnoActivity modificarTurnoActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        month++;
        if (nuevoTurnoActivity != null)
            nuevoTurnoActivity.ChangeDateText(day, month, year);
        else
            modificarTurnoActivity.ChangeDateText(day, month, year);
    }
}