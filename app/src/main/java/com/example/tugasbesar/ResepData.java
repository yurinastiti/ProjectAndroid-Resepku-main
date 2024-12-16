package com.example.tugasbesar;

import java.util.ArrayList;

class ResepData {
    private static String[] resepNames = {
            "Rendang",
            "Sate",
            "Rawon",
            "Steak Ayam",
            "Ayam Geprek",
            "Ayam Kecap",
            "Ayam Teriaki",
            "Puding Coklat",
            "Es krim",
    };

    private static String[] resepDetails = {
            "Bahan: 500 gr daging, 1 batang serai geprek, 3 lembar daun jeruk, 2 lembar daun salam, 1 ruas lengkuas geprek, 2 cm kayu manis, 1 sdt gula merah, 1 sdt kaldu sapi dan garam, 1/2 sdt jintan bubuk, 1/2 sdt merica bubuk, Jeruk nipis, 500 ml santan dari 1/2 kelapa. Bumbu halus: 4 siung bawang putih, 6 butir bawang merah, 2 butir kemiri, 1/2 sdt ketumbar, 3 cabai merah besar (buang bijinya), 2 cm kunyit, 3 cm jahe ",
            "Bumbu kacang: 150 gr kacang tanah goreng, haluskan, 2 lembar daun jeruk, 4 bawang putih goreng, 3 sdm bawang merah goreng, 6 cabai merah keriting goreng, 3 butir kemiri goreng, 3 sdm gula merah serut, 400 ml air, Kecap manis secukupnya, 1 sdt air jeruk nipis ",
            "Bahan : 1 kg daging sapi, 5 lembar daun jeruk purut, 3 lembar daun salam, 2 buah daun bawang, iris dengan panjang 1 cm, 2 batang serai, memarkan, 2 cm lengkuas, memarkan, Merica bubuk, secukupnya, 2 liter air bersih, Gula jawa secukupnya, Garam. Bumbu: 10 siung bawang merah, 6 siung bawang putih, 5 butir kemiri, 5 buah keluak, 2 cm jahe, 1 cm kunyit, 1 cm kencur, ½ sdt ketumbar bubuk, ½ sdt asam jawa, ½ sdt jintan, ½ sdt terasi optional",
            "Bahan: Ayam fillet bagian dada belah menjadi 2, Saus BBQ, Wortel iris korek, Kentang mini, Tomat buah kecil, Garam, Merica, Oregano, Parsley, Keju parmesan, Butter, Margarin, Olive oil atau minyak sayur",
            "Bahan: 1/2 ekor daging ayam, 8 butir bawang merah, 1/2 buah jeruk nipis, 100 gram cabe ijo keriting, minyak kelapa, 1 siung bawang putih, garam dan gula. Bumbu ungkep ayam: 3 siung bawang putih, 2 cm kunyit, 2 cm jahe, 1/2 sdt ketumbar bubuk, garam ",
            "Bahan: 300 gram ayam potong, 1 siung bawang putih, 1 ruas jahe, 200 ml air, 5 buah cabai rawit, 2 butir bawang merah, merica bubuk secukupnya, 2 sendok makan kecap manis, minyak goreng secukupnya, 1 sendok teh gula pasir, garam secukupnya.",
            "Bahan: 300 gram daging ayam, potong,potong, 1 buah jeruk nipis, 1 buah brokoli, potong,potong ,2 siung bawang putih, cincang, 1/2 sdt merica bubuk, garam dan gula secukupnya, 1/2 siung bawang Bombay, 2 sdm saus tiram,  2 sdm saus teriyaki, 1 sdm tepung maizena ",
            "Bahan-bahan: 500 ml susu cair, 3 sendok makan bubuk coklat, 100 gram gula pasir, 2 sendok , makan tepung maizena, 1 sendok teh ekstrak vanila, Topping sesuai selera (potongan buah, krim kocok, coklat parut, dll.)",
            "Bahan:1 lt susu UHT, 3 sdm tepung maizen,1 sdm susu bubuk coklat,6 sdm gula pasir. Cara membuat es krim lembut:Tuangkan susu UHT ke dalam wadah, campurkan pula dengan tepung maizena, susu coklat dan gula. Masak dengan api sedang sambil diaduk-aduk sampai adonan mengental.Jika sudah matang, angkat dan biarkan uap panas hilang. Masukkan ke dalam wadah, lalu masukkan ke dalam freezer dan biarkan hingga membeku.Es yang sudah membeku, diserut dan mixer es hingga halus. Lalu masukkan ke dalam wadah dan masukkan ke dalam freezer lagi.Es krim lembut susu uht siap dinikmati."
             };

    private static int[] resepImages = {
            R.drawable.rendang,
            R.drawable.sate,
            R.drawable.rawon,
            R.drawable.steak_ayam,
            R.drawable.ayam_geprek,
            R.drawable.ayam_kecap,
            R.drawable.ayam_teriyaki,
            R.drawable.puding_coklat,
            R.drawable.es_cream
    };


    static ArrayList<Resep> getListData() {
        ArrayList<Resep> list = new ArrayList<>();
        for (int position = 0; position < resepNames.length; position++) {
            Resep makanan = new Resep();
            makanan.setName(resepNames[position]);
            makanan.setDetail(resepDetails[position]);
            makanan.setPhoto(resepImages[position]);
            list.add(makanan);
        }
        return list;
    }
}