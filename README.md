# PrimaryDetailDemo

Lab Fragment Primary/Detail Flow
Objectives:

    Understand the default Primary/Detail template
    Modify the template to display desired data


Part 1:
Step 1: Create a project, PrimaryDetailDemo, using “Primary/Detail Flow template”
Step 2: You may want to review files under java and layout subdirectories
Step 3: Run the app on phone and tablet (e.g., Nexus 6 and Nexus 9) to see layout on one pane and two panes
Step 3.1: Create Nexus 9 Emulator if you don’t have it (basically prepare a tablet)
Step 3.2: Create Nexus 6 Emulator if you don’t have it (basically prepare a phone)
Step 3.3: On the top of the Editor, select these devices and click Run

Part 2: Modify the template to show a list of web site names and display desired website that a user selects on the detail pane
Step 4: Prepare three websites with id, name and URL in PlaceholderContent.java
Step 4.1: Open PlaceholderContent under placeholder subdirectory under your project. Since we will define websites directly so let’s delete the following statements:
// Find and delete the following statements (i.e., 1 variable and 3 blocks of code)
// Pay attention to those statements because they are not listed consecutively

private static final int COUNT = 25;


static {
// Add some sample items.
for (int i = 1; i <= COUNT; i++) {
addItem(createPlaceholderItem(i));
}
}


private static PlaceholderItem createPlaceholderItem(int position) {

    return new PlaceholderItem(String.valueOf(position), "Item " + position, makeDetails(position));

}



private static String makeDetails(int position) {

    StringBuilder builder = new StringBuilder();

    builder.append("Details about Item: ").append(position);

    for (int i = 0; i < position; i++) {

        builder.append("\nMore details information here.");

    }

    return builder.toString();

}


Step 4.2: Let’s define PlaceholderItem to contain three fields: id, website_name and website_url

In the class PlaceholderItem:

Replace the field “content” by “website_name”
Replace the field “details’ by “website_url”

You can highlight each variable, right click and select Refactor, then select Rename…
On the Rename dialog, put in the new name and click on “Refactor” button
On Rename Constructor Parameters, select the check box for the parameter you want to change and click the “Select all” button and “OK” button

Step 4.3: Initialize data model
Define three websites underneath this following statement
public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem();
)
as follows:


static {

    addItem(new PlaceholderItem("1", "Google", "https://www.google.com"));

    addItem(new PlaceholderItem("2", "Amazon", "https://www.amazon.com"));

    addItem(new PlaceholderItem("3", "Microsoft", "https://www.microsoft.com"));

}


Step 4.4: Run the app and click the list to see the corresponding URL will be shown on the Detail pane
Step 5: As shown at Step 4.4 the default Detail pane will display the URL in the TextView. We need to change the TextView to WebView in the two fragment_item_detail.xml under fragment_item_detail(2) underneath layout
Change the following items in fragment_item_detail.xml
Change TextView to WebView
Remove style attribute

Remove android:textIsSelectable="true"


Do the same thing to fragment_item_detail.xml(sw600dp).
Step 6: Need to change the corresponding java code, ItemDetailFragment, for fragment_item_detail.xml
Step 6.1: import the following libraries
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

Step 6.2: Replace the following 4 statements in onCreateView()
mToolbarLayout = rootView.findViewById(R.id.toolbar_layout);
mTextView = binding.itemDetail;

// Show the placeholder content as text in a TextView & in the toolbar if available.
updateContent();
rootView.setOnDragListener(dragListener);

With the following new statements
if (mItem != null){
binding.itemDetail.setWebViewClient(new WebViewClient(){
@Override
public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
return super.shouldOverrideUrlLoading(view, request);
}
});
binding.itemDetail.loadUrl(mItem.website_url);
}

Some people may put an extra ) after new WebViewClient(). You will have error.
Make sure you keep “return rootView;” as the last statement in the onCreateView()
Step 7: Add INTERNET permission in manifest. Open AndroidManifest.xml. Put in permission between the manifest element and application element as follows:
<manifest xmlns …….>

        <uses-permission android:name="android.permission.INTERNET" />

        <application ……> … </application>

</manifest>


Step 8: Run the app (Use two different screen sizes for phone, Nexus 6, and tablet, Nexus 9, to test it)

Make sure your emulator supports the requirement. But if you use the latest API then it should work.
Submission: Provide 4 screenshots

    List on phone
    Detail with Google for phone
    List on tablet (without detail pane)
    Detail with Microsoft on tablet
