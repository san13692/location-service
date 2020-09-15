# Nearby Locations API

This Spring Boot Application utilizes Here API's to fetch nearby attractions based on Users Location input
## Running the Application

1- We need to generate API key and Oauth token from Here APi website [HERE](https://developer.here.com/projects/) .

```bash
https://developer.here.com/projects/
```
2- Now in our postman we need to generate Oauth1.0 token(as per Here docs) using following call and entering API key and Access key Id just generated-

```bash
curl --location --request POST 'https://account.api.here.com/oauth2/token' \
--header 'Authorization: OAuth oauth_consumer_key="t70PkpoUGO3VI7LvBBuAww",oauth_signature_method="HMAC-SHA256",oauth_timestamp="1600145708",oauth_nonce="Ca7RtDCgAMV",oauth_version="1.0",oauth_signature="E7MhbSKjSQnN3iOi6hF26nY25NckVc5jDVjJyZ9jYO8%3D"' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=client_credentials'
```
3- This Client Id and token needs to be replaced in ApplicationConstant.java class in dto subdirectory-
```java
public static final String TOKEN= "eyJhbGciOiJSUzUxMiIsImN0eSI6IkpXVCIsImlzcyI6IkhFUkUiLCJhaWQiOiJqaXZUYkdwV0pHcVJzdDZrOW45aCIsImlhdCI6MTYwMDE0NTcwNiwiZXhwIjoxNjAwMjMyMTA2LCJraWQiOiJqMSJ9.ZXlKaGJHY2lPaUprYVhJaUxDSmxibU1pT2lKQk1qVTJRMEpETFVoVE5URXlJbjAuLl9rbm9melkzeXY4NXRVNVlLXzJaM2cuUlZvRGxjTm4xLUVuclF4UVdpVUJ5ZnViWXZVWXhLVFVBQTJGcldHV3VTRXlhdnFKdm83aTBpak1FZEhRcy1ndDBRSE5LRmdHdFI0WFNISVNDYWZVQmIwWGNtd09jeE1BelpjYm83ZzBKWHF2dEtvUWtvRzh4WDRoR2V3cVpGTUh2UUtJTktsdFBublpSTDBPT244dTJRLjgtRXhWNFE1cmdMbUhRV3M0TVM0b2V6RVdNMGRjNFphNlAyMW1mTEV1ek0.kVaNOLh1JPgwjX5933md15VFTz73O8JX8O0FU_Q7Bv4VhJSNzqc5m0v2wk8266zyqpymgszzlCI9XaK9rrRdIOGvFaaCzhi0dLIaqvW8eXok2AONwg9qD1HRSbk74L2wpkdu36vfhGaUre_fM_ggGtyRdRkgJz5KZSeX54FMmSpEmEJhem3jV9UfPirrLlNuBw--gxGqmE6NN4vpeaC9yIMEFKOJ5QFbib9_9DFbKwJ3mNWu_9ofjOrUORPDlESLa6FKKPeuOnbwxDc00g8LWYkd_khfmbPEIBK4qtCtMxup_zLwv6zrTokSN71-ROM19irkkuy1iJoLQPkzKc_Zng";
public static final String API_KEY = "VoNjJl18K5GlFk1248a-fgYITnUb8J-rxBlPLEUcZGs";
```

4- Final step is to Run the API and make a GET call using following curl -
```curl
curl --location --request GET 'localhost:8080/locations?query=Connaught%20Place,New%20Delhi'
```
5- Successful Response will be as follows- 
```json
{
    "items": [
        {
            "title": "Silver Spoons",
            "resultType": "place",
            "address": {
                "label": "Silver Spoons, Indira Chowk, Palika Kendra, Connaught Place, New Delhi 110001, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "New Delhi",
                "city": "New Delhi",
                "district": "Connaught Place",
                "subdistrict": "Palika Kendra",
                "postalCode": "110001"
            }
        },
        {
            "title": "Ina Market",
            "resultType": "place",
            "address": {
                "label": "Ina Market, Indira Chowk, Palika Kendra, Connaught Place, New Delhi 110001, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "New Delhi",
                "city": "New Delhi",
                "district": "Connaught Place",
                "subdistrict": "Palika Kendra",
                "postalCode": "110001"
            }
        },
        {
            "title": "Hotel Management",
            "resultType": "place",
            "address": {
                "label": "Hotel Management, Indira Chowk, Palika Kendra, Connaught Place, New Delhi 110001, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "New Delhi",
                "city": "New Delhi",
                "district": "Connaught Place",
                "subdistrict": "Palika Kendra",
                "postalCode": "110001"
            }
        },
        {
            "title": "Ev Plugin Charge",
            "resultType": "place",
            "address": {
                "label": "Ev Plugin Charge, B K Dutt Colony-Block D, Lodhi Colony, Delhi 110003, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "South East",
                "city": "Delhi",
                "district": "Lodhi Colony",
                "subdistrict": "B K Dutt Colony-Block D",
                "postalCode": "110003"
            }
        },
        {
            "title": "Bses Rajdhani Power Limited",
            "resultType": "place",
            "address": {
                "label": "Bses Rajdhani Power Limited, Dev Prakash Shastri Park Marg, Dasghara, Delhi 110010, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "South West",
                "city": "Delhi",
                "district": "Dasghara",
                "postalCode": "110010"
            }
        },
        {
            "title": "Fortum Charger",
            "resultType": "place",
            "address": {
                "label": "Fortum Charger, Netaji Nagar, Delhi 110023, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "South West",
                "city": "Delhi",
                "district": "Netaji Nagar",
                "postalCode": "110023"
            }
        },
        {
            "title": "Innov8 Coworking",
            "resultType": "place",
            "address": {
                "label": "Innov8 Coworking, Connaught Place, New Delhi 110001, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "New Delhi",
                "city": "New Delhi",
                "district": "Connaught Place",
                "postalCode": "110001"
            }
        },
        {
            "title": "NDMC Parking",
            "resultType": "place",
            "address": {
                "label": "NDMC Parking, Connaught Place, New Delhi 110001, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "New Delhi",
                "city": "New Delhi",
                "district": "Connaught Place",
                "postalCode": "110001"
            }
        },
        {
            "title": "Palika Bazaar Parking Area",
            "resultType": "place",
            "address": {
                "label": "Palika Bazaar Parking Area, Palika Kendra, Connaught Place, New Delhi 110001, India",
                "countryCode": "IND",
                "countryName": "India",
                "stateCode": "DL",
                "state": "Delhi",
                "county": "New Delhi",
                "city": "New Delhi",
                "district": "Connaught Place",
                "subdistrict": "Palika Kendra",
                "postalCode": "110001"
            }
        }
    ]
}
```

6- Falied Response will be as follows-
```json
{
    "timestamp": "2020-09-15T13:25:14.894162",
    "message": "No cities found"
}
```
## Caching

For Caching currently we have used @EnableCaching annotation and we are maintaining custom 
CacheManager in CachingConfig.java class inside config subdirectory, which also evicts cache currently after 1 min.
```java
    @CacheEvict(allEntries = true, value = {CACHE})
    @Scheduled(fixedDelay = 600*100, initialDelay = 1000)
    public void reportCacheEvict() {
        System.out.println("Flush Location based Cache ");
    }
```

## ErrorHandling
We are using Custom Error Handling using @ControllerAdvice and maintaing custom error NoDataFoundException.The code for the same is in error sub directory.
Please make sure to update tests as appropriate.

## Contract
For docs and contract we have integrated Swagger with our API.