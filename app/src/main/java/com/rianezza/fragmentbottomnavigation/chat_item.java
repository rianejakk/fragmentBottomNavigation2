package com.rianezza.fragmentbottomnavigation;

import android.os.Parcel;
import android.os.Parcelable;

// Planned to add recycleView on ChatFragment, but scrapped

public class chat_item implements Parcelable {
    private String contact;
    private String chat;

    public chat_item(String contact, String chat) {
        this.contact = contact;
        this.chat = chat;
    }

    protected chat_item(Parcel in) {
        contact = in.readString();
        chat = in.readString();
    }

    public static final Creator<chat_item> CREATOR = new Creator<chat_item>() {
        @Override
        public chat_item createFromParcel(Parcel in) {
            return new chat_item(in);
        }

        @Override
        public chat_item[] newArray(int size) {
            return new chat_item[size];
        }
    };

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(contact);
        parcel.writeString(chat);
    }
}
