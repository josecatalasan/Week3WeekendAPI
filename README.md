# Week3WeekendAPI

This application aims to make two calls to the GitHub API. One to get my own profile information, and another to get the list of my owned repositories.

## HttpUrlConnectionHelper

This helper class does most of the work concerning the API calls of this application. It holds the two URL's for the API calls that this application needs. It was contains two methods, one for each API call, that make the API call, parse the JSON response into Objects, then passes these Objects back the Activity that needs the information.

## MainActivity

This activity contains 6 TextViews, one ImageView, and one FloatingActionButton. It starts an Asynchronous Task using ProfileAsyncTask to make the API call to get my profile information and return that information in a Profile Object. Then, it uses that Profile Object to fill in the Views with information. The Picasso 3rd party library is used to fill the ImageView with the Avatar image in my profile. The floating action button starts RepoListActivity.

## RepoListActivity

This activity contains a single RecyclerView to store and display my list of repositories. It starts another Asynchronous Task using RepoAsyncTask to make the API call to get the list of my owned repositories. The AsyncTask returns an ArrayList of Repository Objects that this activity uses to fill the Adapter that is passed to the RecyclerView.
