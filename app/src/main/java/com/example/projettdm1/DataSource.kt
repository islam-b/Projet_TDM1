package com.example.projettdm1

import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News


object DataSource {
    var newsList = ArrayList<News>()
    var categoriesList= ArrayList<Categorie>()
    var favoritesList= ArrayList<News>()

    var filterContreints = ArrayList<Categorie>()

    init {
        val politique =  Categorie(R.drawable.a,"Politique","سياسة")
        val sport =  Categorie(R.drawable.a,"Sport","رياضة")
        val societe =  Categorie(R.drawable.a,"Societé","مجتمع")
        val economie =  Categorie(R.drawable.a,"Economie","اقتصاد")
        val sante =  Categorie(R.drawable.a,"Santé","صحة")
        val education =  Categorie(R.drawable.a,"Education","تعليم")
        val divers =  Categorie(R.drawable.a,"Divers","متنوع")


        val news1=News(R.drawable.a,"24/04/2019","El Watan","الوطن",R.drawable.a,
            "La révolution populaire en Algérie peut dégénérer", "الثورة الشعبية في الجزائر يمكن أن تتدهور",
            "Si «la révolution populaire» qui frappe l'Algérie depuis le 22 février dernier ne connait pas rapidement une issue positive, «elle peut dégénérer», a déclaré à Sputnik Ali Benouari, ex-ministre algérien du Trésor et expert international en finance. Il estime que le haut commandement de l'Armée nationale populaire (ANP) algérienne, en la personne du général de corps d'armée Ahmed Gaïd Salah, chef d'État-major, était tenu d'apporter des réponses rapides et convaincantes aux aspirations populaires.\n" +
                    "«D'après moi, la situation est dangereuse», a déclaré l'ancien ministre du Trésor. «Nous avons à faire à une révolution pacifique, mais enfin, il ne faut pas tomber dans les travers d'une vision romantique de l'évolution et de l'aboutissement de cette révolution. Elle peut dégénérer. Il peut y avoir des dérapages. Tout dépend maintenant des décisions que prendra le chef d'État-major de l'armée algérienne», a-t-il expliqué.",
            " قال سبوتنيك علي بنواري ، وزير الخزانة الجزائري السابق والخبير الدولي في الشؤون المالية إذا كانت «الثورة الشعبية»  التي تضرب الجزائر منذ 22 فبراير لا تعرف بسرعة نتيجة إيجابية «فإنها يمكن أن تتدهور» . وهو يعتقد أن القيادة العليا للجيش الشعبي الوطني الجزائري (ANP) ، برئاسة الفريق أحمد جايد صلاح ، رئيس الأركان ، كانت مطلوبة لتقديم ردود سريعة ومقنعة على التطلعات شعبية. وقال وزير الخزانة السابق «في رأيي ، الوضع خطير» يتعين علينا القيام به لثورة سلمية ، ولكن في النهاية ، يجب ألا نقع في فخ رؤية رومانسية للتطور ونتائج هذه الثورة. يمكن أن تتحلل. يمكن أن يكون هناك التزلج. كل شيء الآن يعتمد على القرارات التي ستتخذ رئيس أركان الجيش الجزائري",
            politique)

        val news2=News(R.drawable.a,"24/04/2019","Echourouk","الشروق",R.drawable.a,
            "Cour suprême : Un dossier de plainte contre Chakib Khelil réceptionné", "المحكمة العليا: تلقت شكوى ضد شكيب خليل",
            "La Cour suprême a reçu hier mardi les dossiers de poursuite contre l’ancien ministre de l’Énergie, Chakib Khelil et ses acolytes. Dans un communiqué rendu publique, la Cour suprême indique que  « les dossiers portent sur des affaires liées aux infractions au change et le transfert des capitaux de et vers l’Algérie ». Ainsi que « la conclusion des contrats de la Sonatrach avec deux entreprises étrangères».\n" +
                    "\n" +
                    "De ce fait, la Cour suprême a pris en considération, et selon l’article 573 de code des procédures pénales, les dispositifs nécessaires dans ce sens, précise le même communiqué.\n" +
                    "\n" +
                    "L’Art. 573 (Loi n° 90-24 du 18 août 1990) stipule que « Lorsqu’un membre du Gouvernement, un magistrat de la Cour suprême, un wali, un président de Cour ou un procureur général près une Cour, est susceptible d’être inculpé d’un crime ou d’un délit commis dans l’exercice ou par l’exercice de ses fonctions, le Procureur de la République saisi de l’affaire, transmet le dossier, par voie hiérarchique, au procureur général près la Cour suprême qui désigne un membre de la Cour suprême aux fins de procéder à une information.",
                    "تلقت المحكمة العليا أمس قضية الملاحقة القضائية ضد وزير الطاقة السابق شكيب خليل ومعاونيه. في بيان صدر ، ذكرت المحكمة العليا أن \"الملفات تتعلق بقضايا تتعلق بجرائم الصرف الأجنبي وتحويل رأس المال من الجزائر وإليها\". وكذلك \"إبرام عقود سوناتراك مع شركتين أجنبيتين\".\n" +
                            "\n" +
                            "ونتيجة لذلك ، أخذت المحكمة العليا في الاعتبار ، ووفقًا للمادة 573 من قانون الإجراءات الجنائية ، التدابير اللازمة لهذا الغرض ، على حد قول نفس البيان.\n" +
                            "\n" +
                            "الفن. 573 (القانون رقم 90-24 المؤرخ 18 أغسطس 1990) ينص على أنه \"من المحتمل أن يكون قاضٍ في المحكمة العليا أو الوالي أو رئيس المحكمة أو المدعي العام في المحكمة يحيل المدعي العام الذي نظر في القضية ، بتهمة ارتكاب جريمة أو جريمة ارتكبت في ممارسة أو ممارسة وظائفها ، الملف ، هرميًا ، إلى النائب العام في المحكمة العليا تعيين عضو في المحكمة العليا لتقديم المعلومات.",
            politique)

        val news3=News(R.drawable.a,"24/04/2019","Ennahar","النهار",R.drawable.a,
            "Cour suprême : Un dossier de plainte contre Chakib Khelil réceptionné", "المحكمة العليا: تلقت شكوى ضد شكيب خليل",
            "La Cour suprême a reçu hier mardi les dossiers de poursuite contre l’ancien ministre de l’Énergie, Chakib Khelil et ses acolytes. Dans un communiqué rendu publique, la Cour suprême indique que  « les dossiers portent sur des affaires liées aux infractions au change et le transfert des capitaux de et vers l’Algérie ». Ainsi que « la conclusion des contrats de la Sonatrach avec deux entreprises étrangères».\n" +
                    "\n" +
                    "De ce fait, la Cour suprême a pris en considération, et selon l’article 573 de code des procédures pénales, les dispositifs nécessaires dans ce sens, précise le même communiqué.\n" +
                    "\n" +
                    "L’Art. 573 (Loi n° 90-24 du 18 août 1990) stipule que « Lorsqu’un membre du Gouvernement, un magistrat de la Cour suprême, un wali, un président de Cour ou un procureur général près une Cour, est susceptible d’être inculpé d’un crime ou d’un délit commis dans l’exercice ou par l’exercice de ses fonctions, le Procureur de la République saisi de l’affaire, transmet le dossier, par voie hiérarchique, au procureur général près la Cour suprême qui désigne un membre de la Cour suprême aux fins de procéder à une information.",
            "تلقت المحكمة العليا أمس قضية الملاحقة القضائية ضد وزير الطاقة السابق شكيب خليل ومعاونيه. في بيان صدر ، ذكرت المحكمة العليا أن \"الملفات تتعلق بقضايا تتعلق بجرائم الصرف الأجنبي وتحويل رأس المال من الجزائر وإليها\". وكذلك \"إبرام عقود سوناتراك مع شركتين أجنبيتين\".\n" +
                    "\n" +
                    "ونتيجة لذلك ، أخذت المحكمة العليا في الاعتبار ، ووفقًا للمادة 573 من قانون الإجراءات الجنائية ، التدابير اللازمة لهذا الغرض ، على حد قول نفس البيان.\n" +
                    "\n" +
                    "الفن. 573 (القانون رقم 90-24 المؤرخ 18 أغسطس 1990) ينص على أنه \"من المحتمل أن يكون قاضٍ في المحكمة العليا أو الوالي أو رئيس المحكمة أو المدعي العام في المحكمة يحيل المدعي العام الذي نظر في القضية ، بتهمة ارتكاب جريمة أو جريمة ارتكبت في ممارسة أو ممارسة وظائفها ، الملف ، هرميًا ، إلى النائب العام في المحكمة العليا تعيين عضو في المحكمة العليا لتقديم المعلومات.",
            politique)


        newsList.add(news1)
        newsList.add(news2)
        newsList.add(news3)

        categoriesList.add(politique)
        categoriesList.add(sport)
        categoriesList.add(societe)
        categoriesList.add(economie)
        categoriesList.add(sante)
        categoriesList.add(divers)

        favoritesList.add(news2)
        favoritesList.add(news3)
    }

    fun getNews(): ArrayList<News> {
        return newsList
    }

    fun getCategories(): ArrayList<Categorie> {
        return categoriesList
    }

    fun filterNewsByCategories(): ArrayList<News> {
        val res= ArrayList<News>()
        for (i in 0 until newsList.size) {
            for (j in 0 until filterContreints.size) {
                if (newsList[i].categorie == filterContreints[j]) res.add(newsList[i])
            }
        }
        return res
    }

    fun deleteFilterContreint(cat:Categorie):Boolean {
        filterContreints.remove(cat)
        return filterContreints.isEmpty()
    }
    fun addFilterContreint(position: Int) {
        filterContreints.add(categoriesList[position])
    }

    fun clearConstreints() {
        filterContreints.clear()
    }

    fun getFavorites(): ArrayList<News> {
        return favoritesList
    }

    fun addToFavorites(news: News) {
        favoritesList.add(news)
    }
    fun removeFromFavorites(news: News) {
        favoritesList.remove(news)
    }

    fun isFavorite(news: News): Boolean {
        return favoritesList.contains(news)
    }
    fun isConstreint(index:Int):Boolean {
        return filterContreints.contains(categoriesList[index])
    }
}