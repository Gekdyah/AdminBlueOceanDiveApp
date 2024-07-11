package com.example.adminblueoceandive;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnAddGalleryToDatabase;
    private Button btnAddPackageToDatabase;
    private FirebaseDatabase firebaseDatabase;
    private ArrayList<TripPackage> packages = new ArrayList<>();
    private ArrayList<TripGallery> galleries = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddGalleryToDatabase = findViewById(R.id.btn_gallery);
        btnAddPackageToDatabase = findViewById(R.id.btn_package);

        firebaseDatabase = FirebaseDatabase.getInstance();

        initPackagesData();
        initGalleries();

        btnAddGalleryToDatabase.setOnClickListener(v -> {
            addGalleryToDatabase();
            Toast.makeText(this, "Add gallery success", Toast.LENGTH_SHORT).show();
        });
        btnAddPackageToDatabase.setOnClickListener(v -> {
            addPackageToDatabase();
            Toast.makeText(this, "Add package success", Toast.LENGTH_SHORT).show();
        });
    }

    private void addGalleryToDatabase() {
        DatabaseReference dbProcess = firebaseDatabase.getReference("galleries");
        this.galleries.forEach(item -> {
            DatabaseReference galleryRef = dbProcess.push();
            galleryRef.setValue(item);
        });
    }

    private void addPackageToDatabase() {
        DatabaseReference dbProcess = firebaseDatabase.getReference("packages");
        this.packages.forEach(item -> {
            DatabaseReference cartRef = dbProcess.push();
            cartRef.setValue(item);
        });
    }

    private void initGalleries() {
        ArrayList<TripGallery> galleries = new ArrayList<>();

        ArrayList<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%201.jpg?alt=media&token=f5cf9190-496d-4d08-95bb-b20f76af6fd3");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%202.jpg?alt=media&token=02a4a212-7728-4560-9530-3cbd3f14053b");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%203.jpg?alt=media&token=454a95fc-1dc0-4b69-a126-10429335fa64");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%204.jpg?alt=media&token=b61b2a9e-3e3f-482c-a7be-760a3f3ba329");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%205.jpg?alt=media&token=a2ae75a8-304e-4ff2-bd43-aa6dd0308a7c");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%206.jpg?alt=media&token=f7e6adc0-06f6-465f-b5c4-432895c4a132");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%207.jpg?alt=media&token=ef49e4f2-8f6a-4382-8e18-0e88524f6d7f");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%208.jpg?alt=media&token=edeb608a-9910-4e1e-93d4-f03a771ef001");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%209.jpg?alt=media&token=694bdf2e-2734-430c-96d4-e13d782708eb");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%2010.jpg?alt=media&token=fe053b38-1a9a-4c87-8bf4-a5046efabfe6");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/galleries%2Fgallery%2011.jpg?alt=media&token=5798f3fc-0ce9-46a4-9c22-56cd26e005f9");

        imageUrls.forEach(img -> {
            TripGallery tripGallery = new TripGallery();
            tripGallery.setImageUrl(img);
            galleries.add(tripGallery);
        });


        this.galleries = galleries;
    }

    private void initPackagesData() {
        ArrayList<TripPackage> packages = new ArrayList<>();

        // region EDIT BAGIAN INI

        TripPackage package1 = new TripPackage();
        package1.setImageUrl("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/packages%2Fpackage%20amed%20trip.png?alt=media&token=efcbe172-44ce-4ffa-a06f-9525cca964a8");
        package1.setPackageName("Amed Trip 2 Days 1 Night With Hotel & Private Snorkeling");
        package1.setFrontDescription("Private Trip + Documentation");
        package1.setPackageDuration(2);
        package1.setTotalReview(0);
        package1.setPrice(1700000);
        package1.setPriceDescription("1 room can accommodate 2 people. For groups of 6 or more, you will receive 2 private boats.");
        package1.setRating(4f);
        package1.setPackageDescription("Enjoy your holiday in Amed with our 2 days 1 night package, which includes hotel accommodations and private snorkeling. Experience the natural beauty of Amed with its stunning sea views. Amed offers tranquility and a unique atmosphere. In the morning, engage in snorkeling activities, and in the afternoon, watch the beautiful sunset at Amed beach. \n\nSnorkeling Spots\n- Japanese Shipwreck\n" +
                "- Coral Garden (Turtle Point)\n" +
                "- Underwater Temple (Jemeluk Bay)\n" +
                "- Pyramid (Turtle Point)\n");
        package1.setLocation("Amed, Karangasem, Bali");
        package1.setInclude("- Hotel (AC, Bar, Pool, Wifi)\n" +
                "- Private snorkeling boat\n" +
                "- Snorkeling equipment\n" +
                "- Snorkeling guide\n" +
                "- GoPro documentation\n" +
                "- Life jacket\n" +
                "- Bread (for the fish)\n" +
                "- Breakfast\n" +
                "- Mineral water & towel\n" +
                "- Changing room & shower\n");
        package1.setNote("- Meeting point at Baliku Dive Resort\n" +
                "- Please arrive at the meeting point 30 minutes before the booking time\n" +
                "- 2-3 hours duration for snorkeling at 4 spots\n");

//      ===============================================================
        // Tour Package nya package1
        ArrayList<TourPackage> tourPackageList = new ArrayList<>();

        TourPackage tourPackage1 = new TourPackage();
        tourPackage1.setTourPackageName("1 Person");
        tourPackage1.setPrice(1700000);
        tourPackageList.add(tourPackage1);

        // Kalau si package 1 mau punya lebih dari 1 tour package tinggal tambahin lagi selanjutny apabila mau lebih dari 1
        TourPackage tourPackage2 = new TourPackage();
        tourPackage2.setTourPackageName("2 People");
        tourPackage2.setPrice(900000);
        tourPackageList.add(tourPackage2);

        TourPackage tourPackage3 = new TourPackage();
        tourPackage3.setTourPackageName("3 People");
        tourPackage3.setPrice(900000);
        tourPackageList.add(tourPackage3);

        TourPackage tourPackage4 = new TourPackage();
        tourPackage4.setTourPackageName("4 People");
        tourPackage4.setPrice(750000);
        tourPackageList.add(tourPackage4);

        TourPackage tourPackage5 = new TourPackage();
        tourPackage5.setTourPackageName("5 People");
        tourPackage5.setPrice(770000);
        tourPackageList.add(tourPackage5);

        TourPackage tourPackage6 = new TourPackage();
        tourPackage6.setTourPackageName("6 People");
        tourPackage6.setPrice(875000);
        tourPackageList.add(tourPackage6);

        TourPackage tourPackage7 = new TourPackage();
        tourPackage7.setTourPackageName("7 People");
        tourPackage7.setPrice(885000);
        tourPackageList.add(tourPackage7);

        TourPackage tourPackage8 = new TourPackage();
        tourPackage8.setTourPackageName("8 People");
        tourPackage8.setPrice(750000);
        tourPackageList.add(tourPackage8);

        TourPackage tourPackage9 = new TourPackage();
        tourPackage9.setTourPackageName("9 People");
        tourPackage9.setPrice(735000);
        tourPackageList.add(tourPackage9);

        TourPackage tourPackage10 = new TourPackage();
        tourPackage10.setTourPackageName("10 People");
        tourPackage10.setPrice(665000);
        tourPackageList.add(tourPackage10);

        package1.setTourPackages(tourPackageList);
//      ===============================================================

//      ===============================================================
        // Additional Shuttle Servicenya package 1
        ArrayList<PackageAdditionalService> additionalServiceList = new ArrayList<>();

        PackageAdditionalService additionalService1 = new PackageAdditionalService();
        additionalService1.setServiceName("Canggu");
        additionalService1.setPrice(2000000);
        additionalServiceList.add(additionalService1);

        // Kalau si package nya mau punya lebih dari 1 additional service tinggal tambahin lagi selanjutny apabila mau lebih dari 1
        PackageAdditionalService additionalService2 = new PackageAdditionalService();
        additionalService2.setServiceName("Denpasar");
        additionalService2.setPrice(2000000);
        additionalServiceList.add(additionalService2);

        PackageAdditionalService additionalService3 = new PackageAdditionalService();
        additionalService3.setServiceName("Kuta");
        additionalService3.setPrice(2000000);
        additionalServiceList.add(additionalService3);

        PackageAdditionalService additionalService4 = new PackageAdditionalService();
        additionalService4.setServiceName("Legian");
        additionalService4.setPrice(2000000);
        additionalServiceList.add(additionalService4);

        PackageAdditionalService additionalService5 = new PackageAdditionalService();
        additionalService5.setServiceName("Nusa Dua");
        additionalService5.setPrice(2100000);
        additionalServiceList.add(additionalService5);

        PackageAdditionalService additionalService6 = new PackageAdditionalService();
        additionalService6.setServiceName("Sanur");
        additionalService6.setPrice(2000000);
        additionalServiceList.add(additionalService6);

        PackageAdditionalService additionalService7 = new PackageAdditionalService();
        additionalService7.setServiceName("Seminyak");
        additionalService7.setPrice(2000000);
        additionalServiceList.add(additionalService7);

        PackageAdditionalService additionalService8 = new PackageAdditionalService();
        additionalService8.setServiceName("Tabanan");
        additionalService8.setPrice(2100000);
        additionalServiceList.add(additionalService8);

        PackageAdditionalService additionalService9 = new PackageAdditionalService();
        additionalService9.setServiceName("Ubud");
        additionalService9.setPrice(2000000);
        additionalServiceList.add(additionalService9);

        PackageAdditionalService additionalService10 = new PackageAdditionalService();
        additionalService10.setServiceName("Uluwatu");
        additionalService10.setPrice(2100000);
        additionalServiceList.add(additionalService10);

        package1.setAdditionalShuttleService(additionalServiceList);

//      ===============================================================

        packages.add(package1);

        TripPackage package2 = new TripPackage();
        package2.setImageUrl("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/packages%2Fpackage%20amed%20trip.png?alt=media&token=efcbe172-44ce-4ffa-a06f-9525cca964a8");
        package2.setPackageName("Amed Snorkeling Trip With Private Boat");
        package2.setFrontDescription("Private Trip + Documentation");
        package2.setPackageDuration(2);
        package2.setTotalReview(0);
        package2.setPrice(900000);
        package2.setPriceDescription("1 private boat is comfortable for up to 5 people, if there are more, you will get 2 private boats");
        package2.setRating(4f);
        package2.setPackageDescription("Enjoy your holiday in Amed with our snorkeling day trip package. This package includes a private snorkeling boat, 4 best snorkeling spots in Amed, and snorkeling equipment. Experience the underwater beauty of Amed, which includes a world-famous shipwreck spot. Amed offers tranquility and a unique atmosphere. In the morning, you can engage in snorkeling activities, and in the afternoon, you can watch the beautiful sunset in the Amed beach area. \n\nSnorkeling Spots\n" +
                "- Japanese Shipwreck\n" +
                "- Coral Garden (Turtle Point)\n" +
                "- Underwater Temple (Jemeluk Bay)\n" +
                "- Pyramid (Turtle Point)\n");
        package2.setLocation("Amed, Karangasem, Bali");
        package2.setInclude("- Private boat\n" +
                "- Equipement snorkeling\n" +
                "- Life jacket\n" +
                "- Snorkeling guide\n" +
                "- Documentation by gopro\n" +
                "- Bread ( for the fish )\n" +
                "- Mineral water\n" +
                "- Changing room & shower\n" +
                "- Towel\n");
        package2.setNote("Meeting point at Baliku Dive Resort\n" +
                "Please arrive at the meeting point 30 minutes before the booking time\n" +
                "2-3 hours duration for snorkeling at 4 spots\n");

//      ===============================================================
        // Tour Package nya package2
        ArrayList<TourPackage> tourPackageListTwo = new ArrayList<>();

        TourPackage tourPackageTwo1 = new TourPackage();
        tourPackageTwo1.setTourPackageName("1 person");
        tourPackageTwo1.setPrice(900000);
        tourPackageListTwo.add(tourPackageTwo1);

        // Kalau si package 1 mau punya lebih dari 1 tour package tinggal tambahin lagi selanjutny apabila mau lebih dari 1
        TourPackage tourPackageTwo2 = new TourPackage();
        tourPackageTwo2.setTourPackageName("2 People");
        tourPackageTwo2.setPrice(950000);
        tourPackageListTwo.add(tourPackageTwo2);

        TourPackage tourPackageTwo3 = new TourPackage();
        tourPackageTwo3.setTourPackageName("3 People");
        tourPackageTwo3.setPrice(1200000);
        tourPackageListTwo.add(tourPackageTwo3);

        TourPackage tourPackageTwo4 = new TourPackage();
        tourPackageTwo4.setTourPackageName("4 People");
        tourPackageTwo4.setPrice(1300000);
        tourPackageListTwo.add(tourPackageTwo4);

        TourPackage tourPackageTwo5 = new TourPackage();
        tourPackageTwo5.setTourPackageName("5 People");
        tourPackageTwo5.setPrice(1400000);
        tourPackageListTwo.add(tourPackageTwo5);

        TourPackage tourPackageTwo6 = new TourPackage();
        tourPackageTwo6.setTourPackageName("6 People");
        tourPackageTwo6.setPrice(2700000);
        tourPackageListTwo.add(tourPackageTwo6);

        TourPackage tourPackageTwo7 = new TourPackage();
        tourPackageTwo7.setTourPackageName("7 People");
        tourPackageTwo7.setPrice(2800000);
        tourPackageListTwo.add(tourPackageTwo7);

        TourPackage tourPackageTwo8 = new TourPackage();
        tourPackageTwo8.setTourPackageName("8 People");
        tourPackageTwo8.setPrice(3000000);
        tourPackageListTwo.add(tourPackageTwo8);

        TourPackage tourPackageTwo9 = new TourPackage();
        tourPackageTwo9.setTourPackageName("9 People");
        tourPackageTwo9.setPrice(3000000);
        tourPackageListTwo.add(tourPackageTwo9);

        TourPackage tourPackageTwo10 = new TourPackage();
        tourPackageTwo10.setTourPackageName("10 People");
        tourPackageTwo10.setPrice(3000000);
        tourPackageListTwo.add(tourPackageTwo10);

        package2.setTourPackages(tourPackageList);
//      ===============================================================

//      ===============================================================
        // Additional Shuttle Servicenya package 1
        ArrayList<PackageAdditionalService> additionalServiceListTwo = new ArrayList<>();

        PackageAdditionalService additionalServiceTwo1 = new PackageAdditionalService();
        additionalServiceTwo1.setServiceName("Canggu");
        additionalServiceTwo1.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo1);

        // Kalau si package nya mau punya lebih dari 1 additional service tinggal tambahin lagi selanjutny apabila mau lebih dari 1
        PackageAdditionalService additionalServiceTwo2 = new PackageAdditionalService();
        additionalServiceTwo2.setServiceName("Denpasar");
        additionalServiceTwo2.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo2);

        PackageAdditionalService additionalServiceTwo3 = new PackageAdditionalService();
        additionalServiceTwo3.setServiceName("Kuta");
        additionalServiceTwo3.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo3);

        PackageAdditionalService additionalServiceTwo4 = new PackageAdditionalService();
        additionalServiceTwo4.setServiceName("Legian");
        additionalServiceTwo4.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo4);

        PackageAdditionalService additionalServiceTwo5 = new PackageAdditionalService();
        additionalServiceTwo5.setServiceName("Nusa Dua");
        additionalServiceTwo5.setPrice(1000000);
        additionalServiceListTwo.add(additionalServiceTwo5);

        PackageAdditionalService additionalServiceTwo6 = new PackageAdditionalService();
        additionalServiceTwo6.setServiceName("Sanur");
        additionalServiceTwo6.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo6);

        PackageAdditionalService additionalServiceTwo7 = new PackageAdditionalService();
        additionalServiceTwo7.setServiceName("Seminyak");
        additionalServiceTwo7.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo7);

        PackageAdditionalService additionalServiceTwo8 = new PackageAdditionalService();
        additionalServiceTwo8.setServiceName("Tabanan");
        additionalServiceTwo8.setPrice(1000000);
        additionalServiceListTwo.add(additionalServiceTwo8);

        PackageAdditionalService additionalServiceTwo9 = new PackageAdditionalService();
        additionalServiceTwo9.setServiceName("Ubud");
        additionalServiceTwo9.setPrice(950000);
        additionalServiceListTwo.add(additionalServiceTwo9);

        PackageAdditionalService additionalService1Two0 = new PackageAdditionalService();
        additionalService1Two0.setServiceName("Uluwatu");
        additionalService1Two0.setPrice(1000000);
        additionalServiceListTwo.add(additionalService1Two0);

        package2.setAdditionalShuttleService(additionalServiceListTwo);

//      ===============================================================

        packages.add(package2);

        TripPackage package3 = new TripPackage();
        package3.setImageUrl("https://firebasestorage.googleapis.com/v0/b/blueoceandive-1ecc9.appspot.com/o/packages%2Fpackage%20amed%20trip.png?alt=media&token=efcbe172-44ce-4ffa-a06f-9525cca964a8");
        package3.setPackageName("Amed Trip 2 Days 1 Night With Hotel & Private Snorkeling");
        package3.setFrontDescription("Private Trip + Documentation");
        package3.setPackageDuration(2);
        package3.setTotalReview(0);
        package3.setPrice(900000);
        package3.setPriceDescription("1 private boat is comfortable for up to 5 people, if there are more, you will get 2 private boats");
        package3.setRating(5f);
        package3.setPackageDescription("Enjoy your holiday on Gili with us with the high season package, the package includes: hotel, fastboat and private snorkeling. You will feel the beauty of Gili Island with very beautiful sea views, because Gili offers serenity and a special mood for you. In the morning you can do snorkeling activities and in the evening you can party with your friends.");
        package3.setLocation("Amed, Karangasem, Bali");
        package3.setInclude("- Eka Jaya Fastboat Return\n" +
                "- Hotel (AC, Bar, Pool, Wifi)\n" +
                "- Private Boat Snorkeling\n" +
                "- Dokumentasi Underwater by Gopro\n" +
                "- Guide Snorkeling\n" +
                "- Equipment Snorkeling\n" +
                "- Life jacket\n" +
                "- Breakfast\n" +
                "- Restribusi harbour\n");
        package3.setNote("1 room for 2 people\nMeeting point at ekajaya office 08.00 am\n4 Hours Snorkeling at 3 spot\n" +
                "– Turtle Point\n" +
                "– Romantic Statue\n" +
                "– Coral Garden\n" +
                "– Visit to Gili Meno \n" +
                "See Turtle konservasi\n");

//      ===============================================================
        // Tour Package nya package3
        ArrayList<TourPackage> tourPackageListThree = new ArrayList<>();

        TourPackage tourPackageThree1 = new TourPackage();
        tourPackageThree1.setTourPackageName("1 person");
        tourPackageThree1.setPrice(3500000);
        tourPackageListThree.add(tourPackageThree1);

        // Kalau si package 1 mau punya lebih dari 1 tour package tinggal tambahin lagi selanjutny apabila mau lebih dari 1
        TourPackage tourPackageThree2 = new TourPackage();
        tourPackageThree2.setTourPackageName("2 People");
        tourPackageThree2.setPrice(4400000);
        tourPackageListThree.add(tourPackageThree2);

        TourPackage tourPackageThree3 = new TourPackage();
        tourPackageThree3.setTourPackageName("3 People");
        tourPackageThree3.setPrice(6300000);
        tourPackageListThree.add(tourPackageThree3);

        TourPackage tourPackageThree4 = new TourPackage();
        tourPackageThree4.setTourPackageName("4 People");
        tourPackageThree4.setPrice(7600000);
        tourPackageListThree.add(tourPackageThree4);

        TourPackage tourPackageThree5 = new TourPackage();
        tourPackageThree5.setTourPackageName("5 People");
        tourPackageThree5.setPrice(9000000);
        tourPackageListThree.add(tourPackageThree5);

        TourPackage tourPackageThree6 = new TourPackage();
        tourPackageThree6.setTourPackageName("6 People");
        tourPackageThree6.setPrice(10200000);
        tourPackageListThree.add(tourPackageThree6);

        TourPackage tourPackageThree7 = new TourPackage();
        tourPackageThree7.setTourPackageName("7 People");
        tourPackageThree7.setPrice(11275000);
        tourPackageListThree.add(tourPackageThree7);

        TourPackage tourPackageThree8 = new TourPackage();
        tourPackageThree8.setTourPackageName("8 People");
        tourPackageThree8.setPrice(13200000);
        tourPackageListThree.add(tourPackageThree8);

        TourPackage tourPackageThree9 = new TourPackage();
        tourPackageThree9.setTourPackageName("9 People");
        tourPackageThree9.setPrice(14850000);
        tourPackageListThree.add(tourPackageThree9);

        TourPackage tourPackageThree10 = new TourPackage();
        tourPackageThree10.setTourPackageName("10 People");
        tourPackageThree10.setPrice(16500000);
        tourPackageListThree.add(tourPackageTwo10);

        package3.setTourPackages(tourPackageList);
//      ===============================================================

//      ===============================================================
        // Additional Shuttle Servicenya package 1
        ArrayList<PackageAdditionalService> additionalServiceListThree = new ArrayList<>();

        PackageAdditionalService additionalServiceThree1 = new PackageAdditionalService();
        additionalServiceThree1.setServiceName("Canggu");
        additionalServiceThree1.setPrice(800000);
        additionalServiceListThree.add(additionalServiceThree1);

        // Kalau si package nya mau punya lebih dari 1 additional service tinggal tambahin lagi selanjutny apabila mau lebih dari 1
        PackageAdditionalService additionalServiceThree2 = new PackageAdditionalService();
        additionalServiceThree2.setServiceName("Jimbaran");
        additionalServiceThree2.setPrice(850000);
        additionalServiceListThree.add(additionalServiceThree2);

        PackageAdditionalService additionalServiceThree3 = new PackageAdditionalService();
        additionalServiceThree3.setServiceName("Kuta");
        additionalServiceThree3.setPrice(800000);
        additionalServiceListThree.add(additionalServiceThree3);

        PackageAdditionalService additionalServiceThree4 = new PackageAdditionalService();
        additionalServiceThree4.setServiceName("Legian");
        additionalServiceThree4.setPrice(800000);
        additionalServiceListThree.add(additionalServiceThree4);

        PackageAdditionalService additionalServiceThree5 = new PackageAdditionalService();
        additionalServiceThree5.setServiceName("Sanur Dua");
        additionalServiceThree5.setPrice(800000);
        additionalServiceListThree.add(additionalServiceThree5);

        PackageAdditionalService additionalServiceThree6 = new PackageAdditionalService();
        additionalServiceThree6.setServiceName("Seminyak");
        additionalServiceThree6.setPrice(800000);
        additionalServiceListThree.add(additionalServiceThree6);

        PackageAdditionalService additionalServiceThree7 = new PackageAdditionalService();
        additionalServiceThree7.setServiceName("Tabanan");
        additionalServiceThree7.setPrice(850000);
        additionalServiceListThree.add(additionalServiceThree7);

        PackageAdditionalService additionalServiceThree8 = new PackageAdditionalService();
        additionalServiceThree8.setServiceName("Ubud");
        additionalServiceThree8.setPrice(750000);
        additionalServiceListThree.add(additionalServiceThree8);

        package3.setAdditionalShuttleService(additionalServiceListThree);

//      ===============================================================

        packages.add(package3);

        // endregion

        this.packages = packages;
    }
}
