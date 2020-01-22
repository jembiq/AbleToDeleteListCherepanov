package com.example.abletodeletecustomlistcherepanov.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abletodeletecustomlistcherepanov.R;
import com.example.abletodeletecustomlistcherepanov.model.Contact;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<Contact> contacts;
    private LayoutInflater inflater;
    private Context context;

    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contacts != null ? contacts.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return contacts != null ? contacts.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View currentView;
        if(convertView != null) {
            currentView = convertView;
        } else {
            currentView = inflater.inflate(R.layout.item, parent, false);
        }

        Contact contact = (Contact) getItem(position);

        if (contact != null) {
            ImageView imageView = currentView.findViewById(R.id.image);
            TextView contactName = currentView.findViewById(R.id.contact_name);
            TextView contactNumber = currentView.findViewById(R.id.contact_number);
            Button button = currentView.findViewById(R.id.delete_button);

            imageView.setBackgroundResource(R.drawable.icons8_customer64);
            contactName.setText(contact.getContactName());
            contactNumber.setText(contact.getContactNumber());

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    contacts.remove(position);
                    notifyDataSetChanged();
                }
            });

            currentView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    Toast.makeText(context
                            , (position+1) + " position"
                            , Toast.LENGTH_SHORT)
                            .show();

                    return true;
                }
            });
        }

        return currentView;
    }
}

