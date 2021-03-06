package org.opendroidphp.app.fragments.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockDialogFragment;

import org.opendroidphp.app.R;


public class NotifyInstalltionDialogFragment extends SherlockDialogFragment {

    Dialog mDialog;
    TextView titleView;
    TextView messageView;

    final View.OnClickListener rejectInstallation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            mDialog.dismiss();

           /* ToastUtils.toast(
                    getSherlockActivity(),
                    getString(R.string.core_apps_not_installed),
                    Gravity.BOTTOM,
                    Toast.LENGTH_LONG
            ).show();
            */


        }
    };

    final View.OnClickListener proceedInstallation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            // close the current dialog and proceed to the installation setup
            mDialog.cancel();

            new InstallProgressDialogFragment()
                    .show(getFragmentManager(), "do_install");


        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getSherlockActivity().getLayoutInflater();

        mDialog = new Dialog(getSherlockActivity(), R.style.Theme_DroidPHP_Dialog);
        mDialog.setContentView(inflater.inflate(R.layout.dialog_holo, null));

        //Title View
        titleView = (TextView) mDialog.findViewById(R.id.title);
        titleView.setText(R.string.core_apps);

        //Message View
        messageView = (TextView) mDialog.findViewById(R.id.message);
        messageView.setText(R.string.core_apps_not_installed);

        //Buttons and events listener
        Button negativeButton = (Button) mDialog.findViewById(R.id.negative);
        negativeButton.setText(R.string.dont_install);
        negativeButton.setOnClickListener(rejectInstallation);

        Button positiveButton = (Button) mDialog.findViewById(R.id.positive);
        positiveButton.setText(R.string.install);
        positiveButton.setOnClickListener(proceedInstallation);

        return mDialog;
    }


}