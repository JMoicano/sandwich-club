package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String nameLabel = "name";
    private static final String mainNameLabel = "mainName";
    private static final String alsoKnownAsLabel = "alsoKnownAs";
    private static final String placeOfOriginLabel = "placeOfOrigin";
    private static final String descriptionLabel = "description";
    private static final String imageLabel = "image";
    private static final String ingredientsLabel = "ingredients";


    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject object = new JSONObject(json);
        JSONObject name = object.getJSONObject(nameLabel);
        String mainName = name.getString(mainNameLabel);
        JSONArray alsonKnowArray = name.getJSONArray(alsoKnownAsLabel);
        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < alsonKnowArray.length(); ++i) {
            alsoKnownAs.add(alsonKnowArray.getString(i));
        }
        String placeOfOrigin = object.getString(placeOfOriginLabel);
        String description = object.getString(descriptionLabel);
        String image = object.getString(imageLabel);
        JSONArray ingredientsArray = object.getJSONArray(ingredientsLabel);
        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.length(); ++i) {
            ingredients.add(ingredientsArray.getString(i));
        }
        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
