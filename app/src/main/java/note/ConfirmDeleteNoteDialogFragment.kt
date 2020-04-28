package note

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class ConfirmDeleteNoteDialogFragment(val noteTitle: String =""): DialogFragment() {


    interface ListenerDeleteNoteDialog {
        fun positiveButtonClick()
        fun negativeButtonClick()
    }

    var listener : ListenerDeleteNoteDialog? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

       val alertDialog = AlertDialog.Builder(activity!!)
        // Message / buttom (+) and (-)
        alertDialog.setMessage("Êtes-vous sûr(e) de vouoir supprimer \"$noteTitle\" ?")
            .setPositiveButton("Delete", DialogInterface.OnClickListener { dialog, id ->
                listener?.positiveButtonClick()
            })
            .setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, id ->
                listener?.negativeButtonClick()
            })
        return alertDialog.create()
    }

}