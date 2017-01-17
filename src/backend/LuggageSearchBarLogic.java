package backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This utility class holds all methods and constants for searching in the
 * LuggageList screen.
 *
 * @author Elwin Slokker
 */
public class LuggageSearchBarLogic {

    //These are the keys we use to get a translation of the specific keyword for FoundLuggage.
    public static final String[] TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND = {"labelDate",
        "labelAirport", "labelLAFID", "labelLuggageID", "labelStatus",
        "labelFlightnumber", "labelDestination", "labelType", "labelBrand",
        "labelColor", "labelFeatures", "labelName", "labelAddress", "labelCity",
        "labelZipCode", "labelCountry", "labelPhoneNumber", "labelEmail"};
    //Extra strings that count as another keyword.
    public static final String[] SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_FOUND = {
        "LAFID", "lafid", "email", "e-mail"};
    //the indexes the extra strings reference.
    public static final int[] FOUND_SUPPLEMENTARY_TO_KEY_MAP = {2, 2, 17, 17};
    //These are the keys we use to get a translation of the specific keyword for LostLuggage.
    public static final String[] TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_LOST = {"labelDate",
        "labelAirport", "labelLuggageID", "labelStatus", "labelFlightnumber",
        "labelDestination", "labelType", "labelBrand", "labelColor",
        "labelFeatures", "labelName", "labelAddress", "labelCity",
        "labelZipCode", "labelCountry", "labelPhoneNumber", "labelEmail"};
    //Extra strings that count as another keyword.
    public static final String[] SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_LOST = {
        "email", "e-mail"};
    //the indexes the extra strings reference.
    public static final int[] LOST_SUPPLEMENTARY_TO_KEY_MAP = {17, 17};
    //searchables: date, airport, LAFID, luggageID, Status, flightnumber, 
    //destination, type, brand, color, features, traveller name, address,
    //traveller city, zipcode, passenger country, phone number, email

    /**
     * This method is called when one of the search events is called. The entry
     * point for full searching.
     *
     * @param searchString The full String the user entered.
     * @param searchableList The list of Luggages.
     * @param foundMode true if it's a FoundLuggage list, false if it's a
     * LostLuggage list.
     * @return The list that only contains the entries that were not filtered by
     * the search.
     */
    public static ArrayList<Luggage> interpretSearchString(String searchString, ArrayList<Luggage> searchableList, boolean foundMode) {
        if (searchString.isEmpty()) {
            //if there is no search input, no search can be done.
            return searchableList;
        }
        StringBuilder tempString = new StringBuilder();
        int keywordIndex = -1;
        for (int i = 0; i < searchString.length(); i++) {
            if (i != searchString.length() - 1) {
                if (Character.isLetter(searchString.charAt(i))) {
                    tempString.append(searchString.charAt(i));
                } else if (Character.isDigit(searchString.charAt(i))) {
                    tempString.append(searchString.charAt(i));
                } else {//handle symbols
                    switch (searchString.charAt(i)) {
                        case ';':
                            searchableList = filterList(keywordIndex, tempString.toString(), searchableList);
                            tempString.setLength(0);
                            keywordIndex = -1;
                            break;
                        case '=': //interpreted the same as ':'
                        case ':':
                            //keywordMode = isKeyword(tempString.toString());
                            if (foundMode) {
                                keywordIndex = lookupFoundKeyword(tempString.toString());
                            } else {
                                keywordIndex = lookupLostKeyword(tempString.toString());
                            }
                            tempString.setLength(0);
                            break;
                        case '&': //interpreted the same as ','
                        case '+': //interpreted the same as ','
                        case ',': //search and do not change the index
                            searchableList = filterList(keywordIndex, tempString.toString(), searchableList);
                            tempString.setLength(0);
                            break;
                        case ' ': //interpreted the same as '\''
                        case '\'': //this character does not seperate the term/keyword
                            tempString.append(searchString.charAt(i));
                            break;
                        default:
                            continue;//simply ingore everything else
                    }
                }
            } else if (Character.isLetter(searchString.charAt(i))) {
                tempString.append(searchString.charAt(i));
                searchableList = filterList(keywordIndex, tempString.toString(), searchableList);
            } else if (Character.isDigit(searchString.charAt(i))) {
                tempString.append(searchString.charAt(i));
                searchableList = filterList(keywordIndex, tempString.toString(), searchableList);
            } else {//handle symbols
                switch (searchString.charAt(i)) {
                    case ';':
                        searchableList = filterList(keywordIndex, tempString.toString(), searchableList);
                        tempString.setLength(0);
                        keywordIndex = -1;
                        break;
                    case '&': //interpreted the same as ','
                    case '+': //interpreted the same as ','
                    case ',': //search and do not change the index
                        searchableList = filterList(keywordIndex, tempString.toString(), searchableList);
                        tempString.setLength(0);
                        break;
                    case ' ': //interpreted the same as '\''
                    case '\'': //this character does not seperate the term/keyword
                        tempString.append(searchString.charAt(i));
                        break;
                    default:
                        continue;//simply ingore everything else
                    }
            }
        }
        return searchableList;
    }

    /**
     * This method understands all specific index numbers and sends the list to
     * the respective methods.
     *
     * @param keywordIndex The number representing a specific property. Or -1 if
     * none.
     * @param searchString The String to look for.
     * @param searchableList The list of search results.
     * @return A new list with search results.
     */
    public static ArrayList<Luggage> filterList(int keywordIndex, String searchString, ArrayList<Luggage> searchableList) {

        switch (keywordIndex) {
            case -1:
                searchableList = simpleSearch(searchableList, searchString);
                break;
            case 0:
                searchableList = checkDate(searchableList, searchString);
                break;
            case 1:
                searchableList = checkAirport(searchableList, searchString);
                break;
            case 2:
                searchableList = checkLAFID(searchableList, searchString);
                break;
            case 3:
                searchableList = checkLuggageID(searchableList, searchString);
                break;
            case 4:
                searchableList = checkStatus(searchableList, searchString);
                break;
            case 5:
                searchableList = checkFlightnumber(searchableList, searchString);
                break;
            case 6:
                searchableList = checkDestination(searchableList, searchString);
                break;
            case 7:
                searchableList = checkType(searchableList, searchString);
                break;
            case 8:
                searchableList = checkBrand(searchableList, searchString);
                break;
            case 9:
                searchableList = checkColor(searchableList, searchString);
                break;
            case 10:
                searchableList = checkFeatures(searchableList, searchString);
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            default:
                break;
        }
        return searchableList;
    }

    /**
     * This method translates a part of the user input and checks if it is a
     * keyword for a property. This one works only for the input in the
     * FoundLuggage list.
     *
     * @param string A word in the user input.
     * @return -1 if it is no keyword, otherwise the specific keyword number.
     */
    public static int lookupFoundKeyword(String string) {
        int i;
        for (i = 0; i < SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_FOUND.length; i++) {
            if (string.equals(SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_FOUND[i])) {
                //returner = TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND[FOUND_SUPPLEMENTARY_TO_KEY_MAP[i]];
                i = FOUND_SUPPLEMENTARY_TO_KEY_MAP[i];
                break;
            } else if (i == SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_FOUND.length - 1) {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            for (i = 0; i < TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND.length; i++) {
                if (string.toLowerCase().equals(I18N.getTranslation(TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND[i]).toLowerCase())
                        || string.toLowerCase().equals(I18N.getEnglishTranslation(TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND[i]).toLowerCase())) {
                    break;
                } else if (i == TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND.length - 1) {
                    i = -1;
                    break;
                    //return "";
                }
            }
            //returner = I18N.getEnglishTranslation(TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_FOUND[i]);
        }
        return i; //keyword
    }

    /**
     * This method translates a part of the user input and checks if it is a
     * keyword for a property. This one works only for the input in the
     * FoundLuggage list.
     *
     * @param string A word in the user input.
     * @return -1 if it is no keyword, otherwise the specific keyword number.
     */
    public static int lookupLostKeyword(String string) {
        int i;
        for (i = 0; i < SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_LOST.length; i++) {
            if (string.equals(SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_LOST[i])) {
                i = LOST_SUPPLEMENTARY_TO_KEY_MAP[i];
                break;
            } else if (i == SUPPLEMENTARY_ALLOWED_SEARCH_KEYWORDS_LOST.length - 1) {
                i = -1;
                break;
            }
        }
        if (i == -1) {
            for (i = 0; i < TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_LOST.length; i++) {
                if (string.toLowerCase().equals(I18N.getTranslation(TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_LOST[i]).toLowerCase())
                        || string.toLowerCase().equals(I18N.getEnglishTranslation(TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_LOST[i]).toLowerCase())) {
                    break;
                } else if (i == TRANSLATION_KEYS_OF_POSSIBLE_SEARCH_KEYWORDS_LOST.length - 1) {
                    i = -1;
                    break;
                }
            }
        }
        return i; //key number
    }

    /**
     * This method does not take different properties in account and 'simply'
     * uses luggage.toString();
     *
     * @param searchable The list of search results.
     * @param term The String to look for in every luggage.
     * @return A new list of search results.
     */
    public static ArrayList<Luggage> simpleSearch(ArrayList<Luggage> searchable, String term) {
        /*
        for(int i = 0; i < searchable.size(); i++){
            if (!searchable.get(i).toString().contains(term)){
                searchable.remove(i);
            }
        }
        This would be a prefered method, but removing an item also changes indexes,
        making it harder to understand.
         */
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.toString().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    /*
    All methods beyond this points are almost copies.
    Each one of them filters their own specific trait.
     */
    public static ArrayList<Luggage> checkDate(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getDate().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkAirport(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getAirport().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkLAFID(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        FoundLuggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = ((FoundLuggage) searcher.next());
            if (temp.getLostFoundID().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkLuggageID(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getLuggageID().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkStatus(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getStatus().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkFlightnumber(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getFlightNumber().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkDestination(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getDestination().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkType(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getType().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkBrand(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getBrand().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkColor(ArrayList<Luggage> searchable, String term) {
        ArrayList<Luggage> newList = new ArrayList<>();
        Luggage temp;
        Iterator searcher = searchable.iterator();
        while (searcher.hasNext()) {
            temp = (Luggage) searcher.next();
            if (temp.getColor().contains(term)) {
                newList.add(temp);
            }
        }
        return newList;
    }

    public static ArrayList<Luggage> checkFeatures(ArrayList<Luggage> searchable, String term) {
        System.out.println("Searching on features is not possible yet");
        return searchable;
    }
    /*
    public void checkTraveller(){
        
    }
    public ArrayList<Luggage> checkName(ArrayList<Luggage> searchable){

    }
    public ArrayList<Luggage> checkAddress(ArrayList<Luggage> searchable){
                         
    }
    public ArrayList<Luggage> checkCity(ArrayList<Luggage> searchable){

    }
    public ArrayList<Luggage> checkZipcode(ArrayList<Luggage> searchable){

    }
    public ArrayList<Luggage> checkCountry(ArrayList<Luggage> searchable){

    }
    public ArrayList<Luggage> checkPhoneNumber(ArrayList<Luggage> searchable){

    }
    public ArrayList<Luggage> checkEmail(ArrayList<Luggage> searchable){

    }
     */
}
