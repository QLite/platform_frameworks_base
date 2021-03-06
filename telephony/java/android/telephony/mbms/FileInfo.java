/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.telephony.mbms;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A Parcelable class Cell-Broadcast downloadable file information.
 * @hide
 */
public class FileInfo implements Parcelable {

    /**
     * The URI into the carriers infrastructure which points to this file.
     * This is used internally but is also one of the few pieces of data about the content that is
     * exposed and may be needed for disambiguation by the application.
     */
    private final Uri uri;

    /**
     * The mime type of the content.
     */
    private final String mimeType;

    public static final Parcelable.Creator<FileInfo> CREATOR =
            new Parcelable.Creator<FileInfo>() {
        @Override
        public FileInfo createFromParcel(Parcel source) {
            return new FileInfo(source);
        }

        @Override
        public FileInfo[] newArray(int size) {
            return new FileInfo[size];
        }
    };

    /**
     * @hide
     * TODO: systemapi
     */
    public FileInfo(Uri uri, String mimeType) {
        this.uri = uri;
        this.mimeType = mimeType;
    }

    private FileInfo(Parcel in) {
        uri = in.readParcelable(null);
        mimeType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(uri, flags);
        dest.writeString(mimeType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Uri getUri() {
        return uri;
    }

    public String getMimeType() {
        return mimeType;
    }
}
