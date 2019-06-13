package com.example.projettdm1

import com.example.projettdm1.models.Categorie
import com.example.projettdm1.models.News


object DataSource {
    var newsList = ArrayList<News>()
    var categoriesList= ArrayList<Categorie>()
    var favoritesList= ArrayList<News>()

    var filterContreints = ArrayList<Categorie>()

    init {
        val politique =  Categorie(R.drawable.politics,"Politique","سياسة")
        val sport =  Categorie(R.drawable.sport,"Sport","رياضة")
        val societe =  Categorie(R.drawable.societe,"Societé","مجتمع")
        val economie =  Categorie(R.drawable.economie,"Economie","اقتصاد")
        val sante =  Categorie(R.drawable.sante,"Santé","صحة")
        val education =  Categorie(R.drawable.education,"Education","تعليم")
        val divers =  Categorie(R.drawable.divers,"Divers","متنوع")

        val news1=News(R.drawable.news1,"24/04/2019","El Watan","الوطن",
            "La révolution populaire en Algérie peut dégénérer", "الثورة الشعبية في الجزائر يمكن أن تتدهور",
            "Si «la révolution populaire» qui frappe l'Algérie depuis le 22 février dernier ne connait pas rapidement une issue positive, «elle peut dégénérer», a déclaré à Sputnik Ali Benouari, ex-ministre algérien du Trésor et expert international en finance. Il estime que le haut commandement de l'Armée nationale populaire (ANP) algérienne, en la personne du général de corps d'armée Ahmed Gaïd Salah, chef d'État-major, était tenu d'apporter des réponses rapides et convaincantes aux aspirations populaires.\n" +
                    "«D'après moi, la situation est dangereuse», a déclaré l'ancien ministre du Trésor. «Nous avons à faire à une révolution pacifique, mais enfin, il ne faut pas tomber dans les travers d'une vision romantique de l'évolution et de l'aboutissement de cette révolution. Elle peut dégénérer. Il peut y avoir des dérapages. Tout dépend maintenant des décisions que prendra le chef d'État-major de l'armée algérienne», a-t-il expliqué.",
            " قال سبوتنيك علي بنواري ، وزير الخزانة الجزائري السابق والخبير الدولي في الشؤون المالية إذا كانت «الثورة الشعبية»  التي تضرب الجزائر منذ 22 فبراير لا تعرف بسرعة نتيجة إيجابية «فإنها يمكن أن تتدهور» . وهو يعتقد أن القيادة العليا للجيش الشعبي الوطني الجزائري (ANP) ، برئاسة الفريق أحمد جايد صلاح ، رئيس الأركان ، كانت مطلوبة لتقديم ردود سريعة ومقنعة على التطلعات شعبية. وقال وزير الخزانة السابق «في رأيي ، الوضع خطير» يتعين علينا القيام به لثورة سلمية ، ولكن في النهاية ، يجب ألا نقع في فخ رؤية رومانسية للتطور ونتائج هذه الثورة. يمكن أن تتحلل. يمكن أن يكون هناك التزلج. كل شيء الآن يعتمد على القرارات التي ستتخذ رئيس أركان الجيش الجزائري",
            politique)

        val news2=News(R.drawable.news2,"24/04/2019","Echourouk","الشروق",
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

        val news3=News(R.drawable.news3,"25/04/2019","Ennahar","النهار",
            "Sonatrach : Les privilèges accordés par Ould Kaddour à des compagnies étrangères", "سوناتراك: الامتيازات التي يمنحها ولد قدور للشركات الأجنبية",
                    "Deux mois sont passés depuis le début de la révolution populaire pacifique. Ces dernières semaines, on a pu assister à un feuilleton judiciaire plain de rebondissements. Les langues commencent donc à se délier et les grosses affaires remontent à la surface. L’une d’elles concerne la source de revenus du pays (Sonatrach) est son ex-PDG, le très controversé Abdelmoumen Ould Kaddour.  \n" +
                            "\n" +
                            "El Khabar s’est penché ce jeudi sur le cas Ould Kaddour. Dans sa publication, le journal s’est interrogé sur les méthodes utilisées par ce dernier pour régler pas moins de 11 contentieux avec des géants mondiaux des hydrocarbures.\n" +
                            "\n" +
                            "Avant de rendre la direction de la Sonatrach en mars 2017, plusieurs responsables s’étaient succédés à sa tête avant lui et aucun n’a pu y remédier aussi rapidement et avec une telle efficacité. L’Algérie était traînée auprès des instances d’arbitrage dans 11 affaires l’opposant à des sociétés très puissantes dans un domaine ou le gros poisson finit toujours par dévorer les plus petits.\n" +
                            "\n" +
                            "Se référant à une source proche de ce dossier, El Khabar a révélé que l’ex-patron de la Sonatrach a cédé sur des affaires que l’Algérie était sur le point de gagner comme celles qui l’opposaient à l’espagnol Repsol et au français Total. Ces deux compagnies réclamaient, auprès des instances arbitrales internationales, un dédommagement du fait de l’application de la loi par Sonatrach concernant la mise en œuvre de la taxe sur les profits exceptionnels instaurée en 2006.\n" +
                            "\n" +
                            "Au lieu de patienter le temps que l’instance d’arbitrage rende son verdict, Ould Kaddour a préféré régler le contentieux à l’amiable, après avoir eu le feu vert d’Ahmed Ouyahia, Premier ministre de l’époque. L’ex-patron de la Sonatrach a accordé de nouveaux contrats d’exploitation de gaz aux deux géants européens dans la région de Tin Fouyé Tabankort à Ouargla.\n" +
                            "\n" +
                            "La même source a également indiqué que l’Algérie a renouvelé un contrat d’exploitation dans les gisements d’In Amenas en offrant à l’espagnol Repsol 20 ans d’exploitation supplémentaires !",
                    "لقد مر شهرين منذ بداية ثورة الشعب المسالمة. في الأسابيع الأخيرة ، شهدنا مسلسلًا قضائيًا سهل التحولات والانعطافات. بدأت اللغات في فك الارتباط وبدأت الشركات الكبيرة في الظهور. أحدها يتعلق بمصدر الدخل في البلاد (Sonatrach) هو الرئيس التنفيذي السابق ، المثير للجدل عبد المؤمن ولد قدور.\n" +
                            "\n" +
                            "انحنى الخبر هذا الخميس على قضية ولد قدور. في منشوراتها ، تساءلت الصحيفة عن الأساليب التي تستخدمها الأخيرة لتسوية ما لا يقل عن 11 نزاعاً مع شركات النفط العالمية العملاقة.\n" +
                            "\n" +
                            "قبل العودة إلى إدارة سوناتراك في مارس 2017 ، اتبع العديد من القادة تقدمه أمامه ولم يتمكن أي منهم من معالجته بسرعة وبكفاءة عالية. تم جر الجزائر لإجراءات التحكيم في 11 قضية ضد شركات قوية للغاية في حقل حيث تنتهي السمكة الكبيرة دائمًا في التهام أصغرها.\n" +
                            "\n" +
                            "بالإشارة إلى مصدر مقرب من هذه القضية ، كشف الخبر أن الرئيس السابق لسوناتراك استسلم لصفقات كانت الجزائر على وشك الفوز بها ، مثل تلك التي وقعت ضد ريبسول الأسباني و إلى الفرنسية المجموع. تسعى هاتان الشركتان إلى الحصول على تعويض من هيئات التحكيم الدولية عن تطبيق Sonatrach للقانون المتعلق بتنفيذ الضريبة على الأرباح غير العادية التي تم تقديمها في عام 2006.\n" +
                            "\n" +
                            "بدلاً من انتظار الوقت الذي تصدر فيه هيئة التحكيم حكمها ، فضل ولد قدور تسوية النزاع بشكل ودي ، بعد الحصول على الضوء الأخضر لأحمد أويحيى ، رئيس وزراء ذلك الوقت. منح الرئيس السابق لشركة Sonatrach عقودًا جديدة لاستغلال الغاز للعملاقين الأوروبيين في منطقة Tin Fouyé Tabankort في ولاية ورقلة.\n" +
                            "\n" +
                            "كما أشار المصدر نفسه إلى أن الجزائر قد جددت عقد تعدين في رواسب In Amenas من خلال تقديم 20 ثانية من الاستغلال الإضافي لشركة ريبسول الإسبانية!",
            politique)

        val news4=News(R.drawable.news4,"25/04/2019","Liberté","الحرية",

                    "Moussa Naït-Amara à Bouira\n" +
                    "“Rebrab est victime de son patriotisme économique”\n", "موسى ناع عمارة في البويرة\n" +
                    "\"ربراب هو ضحية وطنيته الاقتصادية\"",

                            "Ancien membre du Mouvement culturel berbère (MCB) et militant de la démocratie, Moussa Naït-Amara était, hier, l’hôte du collectif des étudiants libres de l’université Akli Mohand-Oulhadj de Bouira, où il a animé une conférence-débat ayant pour thème “La transition et la refondation de l’État”. Avant d’entamer sa conférence, M. Naït-Amara a tenu à rendre hommage à Issad Rebrab, P-DG du groupe Cevital, qui est actuellement incarcéré, dit-il, pour des “raisons politiques”. \n" +
                            "\n" +
                            "D’ailleurs, ce dernier a profité de la tribune qui lui était offerte pour lancer : “Naâm li marhala intaqaliya, la li marhala intiqamiya” (oui pour une période de transition, non pour une période de vengeance). \n" +
                            "Un message limpide sur les véritables raisons de la mise sous mandat de dépôt du patron de Cevital. “Issad Rabrab est victime d’une cabale car il n’est pas et il n’a jamais été l’homme des clans. C’est un homme à la liberté d’entreprendre hors du commun, et c’est cette liberté qui lui a valu tant de mésaventures et de blocages jusqu’à son incarcération”, a-t-il expliqué. Mieux encore, selon M. Naït-Amara, Rebrab paie actuellement son refus de la compromission et du clientélisme pour un clan défini. “Contrairement à ce que j’ai pu entendre ici et là, Rebrab n’a pas été jeté en prison car il est Kabyle, il l’a été sur injonction de la justice du téléphone, puisqu’il a toujours refusé de faire passer ses intérêts et ceux d’un certain clan au détriment des intérêts de l’économie nationale”, tranchera le conférencier. \n" +
                            "Et d’enfoncer le clou : “Je le dis et j’assume mes propos, je souhaite qu’il y ait des milliers de Rebrab en Algérie.” À propos de la fameuse “justice de la nuit” qui fait débat actuellement, l’orateur a mis en exergue que, dans le contexte actuel des choses, évoquer le jugement de certaines personnalités publiques est une “diversion”.  \n" +
                            "“Qui juge qui ? La justice, la vraie, ne peut être efficace et crédible que dans les conditions d’un État de droit. Or, actuellement, la rue demande le départ de l’ensemble des figures du système, et non leur jugement. Lorsqu’on aura édifié un État de droit et où la justice sera libre et indépendante, à ce moment-là, ils paieront tous”, indiquera l’ex-membre du MCB. \n" +
                            "Au sujet du thème principal de la conférence, l’hôte de Bouira exclut totalement l’implication de l’institution militaire dans la phase de transition. “On doit sortir de cette impasse dans laquelle on s’est engouffrés au lendemain de l’indépendance. L’institution militaire a un rôle bien déterminé, celui de protéger nos frontières et non de s’impliquer dans la vie politique du pays”, préconisera-t-il. “On doit absolument sortir de la République des putschs, pour passer à une République où le civil prime sur le militaire”, assènera-t-il. \n" +
                            "Moussa Naït-Amara exhortera le mouvement populaire à s’organiser autour de corporations en vue de la prochaine phase de transition qui devra inclure toutes les franges de la société, sans exclusion aucune.",
            "كان موسى ناع عمارة ، العضو السابق في الحركة الثقافية البربرية (MCB) وناشطًا في مجال الديمقراطية ، مضيفًا يوم أمس لجمعية الطلاب الأحرار لجامعة أكلي محند أولحاج البويرة ، حيث استضاف نقاشًا في مؤتمر مع موضوع \"الانتقال وإعادة بناء الدولة\". قبل أن يبدأ محاضرته ، أشاد نايت عمارة بإسعد ربراب ، الرئيس التنفيذي لمجموعة سيفيتال ، المسجون حاليًا ، \"لأسباب سياسية\".\n" +
                    "\n" +
                    "علاوة على ذلك ، استفاد الأخير من المنصة المعروضة له لإطلاق: \"Naam li marhala intaqaliya ، li marhala intiqamiya\" (نعم لفترة انتقالية ، وليس لفترة انتقامية).\n" +
                    "رسالة واضحة حول الأسباب الحقيقية لتقديم رئيس Cevital ل. \"أسعد رراب ضحية عصابة لأنه لم يكن ولم يكن أبداً رجل العشائر. إنه رجل يتمتع بحرية التصرف خارجا عن المألوف ، وهذه الحرية هي التي جلبت له الكثير من الحوادث والقيود حتى سجنه \". والأفضل من ذلك ، وفقًا للسيد نايت عمارة ، أن Rebrab يدفع حاليًا رفضه للتسوية والعملاء لعشيرة محددة. \"على عكس ما سمعت هنا وهناك ، لم يتم إلقاء Rebrab في السجن لأنه قبايلي ، لقد كان بناءً على أمر من عدالة الهاتف ، لأنه كان دائمًا يرفض المرور مصالحها ومصالح عشيرة معينة على حساب مصالح الاقتصاد الوطني \"، سوف يقرر المتحدث.\n" +
                    "ولتحقيق الهدف: \"أقولها وأغتنم كلماتي ، أتمنى أن يكون هناك الآلاف من Rebrab في الجزائر.\" حول \"العدالة الشهيرة\" التي تناقشها حاليًا ، وأشار المتحدث إلى أنه في السياق الحالي للأشياء ، فإن استحضار حكم بعض الشخصيات العامة هو \"تحويل\".\n" +
                    "\"من يحكم من؟ إن العدالة ، الحقيقية ، لا يمكن أن تكون فعالة وذات مصداقية إلا في ظل ظروف سيادة القانون. الآن ، في الوقت الحاضر ، يطالب الشارع برحيل جميع شخصيات النظام ، وليس حكمهم. وقال العضو السابق في بنك MCB: \"عندما نبني سيادة القانون والعدالة ستكون حرة ومستقلة ، فسوف يدفعون جميعًا\".",
            politique)

        val news5=News(R.drawable.news5,"24/04/2019","El Haddaf","الوطن",
            "Et si Guardiola entraînait Ronaldo ?", "ماذا لو قام جوارديولا بتدريب رونالدو؟",
            "Arrivé en 2016 sur le banc de Manchester City, Pep Guardiola avait prolongé, en mai dernier, son contrat jusqu’en 2021, avec un salaire annuel passant de 15 à 20 millions de livres, soit un peu plus de 23 millions d’euros par an. Et s’il avait parlé cet hiver de la possibilité d’une nouvelle prolongation, il n’a plus évoqué le sujet depuis, notamment après la nouvelle élimination des Citizens en quarts de finale de la Ligue des champions.\n" +
                    "\n" +
                    "Mais à en croire Luigi Guelpa, un journaliste italien d’Il Giornale qui avait annoncé avant tout le monde l’arrivée de Cristiano Ronaldo à la Juventus, le technicien catalan se serait déjà mis d’accord avec la Vieille Dame pour un contrat de 4 ans, assurait-il le mois dernier à l’antenne de la Radio CRC.",
            "وصل Pep Guardiola ، الذي وصل عام 2016 على مقاعد البدلاء في مدينة مانشستر سيتي ، في مايو الماضي ، عقده حتى عام 2021 ، براتب سنوي من 15 إلى 20 مليون جنيه ، أو ما يزيد قليلاً عن 23 مليون يورو بحلول العام. وإذا كان قد تحدث هذا الشتاء عن إمكانية تمديد جديد ، فهو لم يشر إلى الموضوع منذ ذلك الحين ، خاصة بعد الإقصاء الجديد للمواطنين في الدور ربع النهائي من دوري أبطال أوروبا.\n" +
                    "\n" +
                    "لكن وفقًا لويجي غيلبا ، الصحفي الإيطالي من إل جورنال الذي أعلن قبل وصول العالم أجمع عن وصول كريستيانو رونالدو إلى يوفنتوس ، كان الفني الكاتالوني قد وافق بالفعل مع السيدة العجوز على عقد مدته 4 سنوات ، أكد الشهر الماضي على الهواء من راديو CRC.",
            sport)

        val news6=News(R.drawable.news6,"24/04/2019","El Haddaf","الشباك",
            "Doukha : \"Il y avait un accord avec la victoire mais ...\"", "دوخة: “كان هناك إتفاق مع النصر ولكن..”",
            "Le gardien international algérien Ezzeddin Douakha a révélé qu'il était sur le point de rejoindre le géant saoudien Al-Nasr.\n" +

                    "Dans un entretien avec la chaîne sportive saoudienne, il a déclaré: \"Il y avait un accord officiel sur la victoire de l'Arabie saoudite, mais le changement de chef de l'équipe l'a empêché.\"\n" +
                    "\n" +
                    "D'autre part, l'ancien gardien de l'Union de Harrach, sa signature avec le pionnier saoudien était convaincue, et Aldel pour ce grand éclat avec l'équipe au cours de la saison en cours.",
            "\n" +
                    "كشف الحارس الدولي الجزائري عز الدين دوخة ، بانه كان قريبا من الإنضمان إلى العملاق السعودي نادي النصر.\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "دوخة وفي حوار له مع قناة السعودية الرياضية، قال: “كان هناك إتفاق رسمي مع النصر السعودي، ولكن تغييرهم لرئيس الفريق حال دون ذلك”.\n" +
                    "\n" +
                    "من جهة أخرى أكد الحارس السابق لإتحاد الحراش، أن توقيعه مع الرائد السعودي كان عن قناعة، والديل على ذلك تألقه الكبير مع الفريق خلال الموسم الحالي.\n",
            sport)

        val news7=News(R.drawable.news7,"23/04/2019","L'Express","الاكسبريس",
            "Une riche Saoudienne poursuivie à Paris pour traite d'êtres humains", "دعوى قضائية ضد امرأة سعودية غنية في باريس بسبب تهريب البشر",

                    "Une riche saoudienne résidant à deux pas de la Tour Eiffel est poursuivie à Paris pour traite d'être humains, travail dissimulé et emploi d'étrangers non munis d'une autorisation de travail.\n" +
                    "\n" +
                    "afp.com/GERARD JULIEN\n" +
                    "Shalimar Sharbatly a été dénoncée par ses employées de maison. Interpellée et placée en garde à vue le 18 avril dernier, elle a été convoquée au tribunal.\n" +
                    "\n" +
                    "Une riche saoudienne résidant à deux pas de la Tour Eiffel est poursuivie à Paris pour traite d'être humains, travail dissimulé et emploi d'étrangers non munis d'une autorisation de travail. " +
                    "Shalimar Sharbatly, première artiste saoudienne à avoir eu l'autorisation du gouvernement de son pays pour réaliser des fresques murales et autres graffitis dans plusieurs villes du Royaume, a été dénoncée par ses employés de maison originaires d'Érythrée ou de Somalie, rapportent France Inter et Le Pointce jeudi. Des personnes sans papiers très vulnérables.  \n" +
                    "Trois personnes dans une chambre de 7m2\n" +
                    "\n" +
                    "Une employée a par exemple indiqué à la police qu'elle était séquestrée par l'artiste, qui a été interpellée et placée en garde à vue le 18 avril, avant d'être convoquée au tribunal le 7 mai prochain. Les enquêteurs ont indiqué au Point que \"les domestiques étaient soumises à des conditions de travail et d'hébergement contraires à la dignité humaine\". ",
            "شاليمار شربتلي ، أول فنانة سعودية تحصل على إذن من حكومة بلدها لتصوير الجداريات وغيرها من الرسوم على الجدران في العديد من مدن المملكة ، ندد بها عاملات المنازل من إريتريا أو الصومال ، وفقًا لتقرير فرانس إنتر و بوينتس الخميس. الناس الذين لا يحملون وثائق ضعفاء للغاية.\n" +
                    "ثلاثة أشخاص في غرفة 7m2\n" +
                    "\n" +
                    "على سبيل المثال ، أخبرت موظفة الشرطة أنها احتجزتها الفنانة ، التي قُبض عليها واحتُجزت في 18 أبريل / نيسان قبل استدعائها إلى المحكمة في 7 مايو / أيار. وقال المحققون للنقطة إن \"عاملات المنازل تعرضن لظروف عمل وإقامة تتعارض مع كرامة الإنسان\".",
            societe)

        val news8=News(R.drawable.news8,"25/04/2019","L'Express","الاكسبريس",
            "Sanofi: Journée d’information et de formation dédiée aux journalistes", " سانوفي: يوم معلومات وتدريب مخصص للصحفيين",

            "Sanofi Algérie à organiser à une journée d’information workshop dédiée aux journalistes qui souhaitent en apprendre davantage sur différentes pathologies et ainsi enrichir leur connaissance techniques sur les sujets liés à la santé.\n" +
                    "\n" +
                    "Une première session ,Aux côtés d’experts et professeurs spécialistes du domaine, une louable initiatives qui  permettra d’échanger sur les aires thérapeutiques suivantes :  le diabète et ses complications, l’hypertension artérielle, les maladies rares et enfin les maladies infectieuses et la vaccination.\n" +
                    "\n" +
                    "« c’est ainsi que l’objectif de cette journée rejoint notre ambition d’être le partenaire de références de tous les acteurs qui œuvrent pour la santé en Algérie, spécialement avec les médias dont le rôle dans l’information liée à la santé est primordiale , notamment pour combattre les idées reçues, informer et sensibiliser sur les risques et moyens de prévention. » dira Rym Fettouche , directrice de la communication",
                "سانوفي الجزائر تنظم يوماً من ورش العمل الإعلامية المكرسة للصحفيين الذين يرغبون في معرفة المزيد عن الأمراض المختلفة ، وبالتالي إثراء معارفهم التقنية في المواضيع المتعلقة بالصحة.\n" +
                        "\n" +
                        "جلسة أولى ، إلى جانب الخبراء والأساتذة المتخصصين في هذا المجال ، وهي مبادرة جديرة بالثناء تتيح مناقشة المجالات العلاجية التالية: مرض السكري ومضاعفاته وارتفاع ضغط الدم والأمراض النادرة والأمراض المعدية وأخيرا التطعيم.\n" +
                        "\n" +
                        "\"هذه هي الطريقة التي يتناسب بها هدف هذا اليوم مع طموحنا في أن نكون الشريك المرجعي لجميع الجهات الفاعلة التي تعمل في مجال الصحة في الجزائر ، خاصةً مع وسائل الإعلام التي يتمثل دورها في المعلومات المتعلقة بالصحة\" من الأمور الأساسية ، وخاصة لمكافحة المفاهيم الخاطئة ، إعلام ورفع الوعي حول مخاطر ووسائل الوقاية. يقول ريم فتوش ، مدير الاتصالات",
            sante)

        val news9=News(R.drawable.news9,"25/04/2019","L'Express","الاكسبريس",
            "Les dates du bac, du BEM et de la 5e fixées", "مواعيد البكالوريا ، بيم والخامس محددة ",


                    "Le ministère de l'Éducation nationale a rendu  public, jeudi, dans un communiqué, le calendrier des examens nationaux des trois paliers pour l'année scolaire 2018/2019 (bac, BEM et 5e). L'examen du baccalauréat aura lieu du 16 au 20 juin, celui du Brevet d'enseignement moyen (BEM) du 9 au 11 juin, tandis que l'examen de la 5e année primaire est fixé au 29 mai, a précisé la même source.\n",
            "أصدرت وزارة التربية والتعليم يوم الخميس ، في بيان ، جدول الامتحانات الوطنية من ثلاثة مستويات للعام الدراسي 2018/2019 (البكالوريا ، BEM و 5). وقال المصدر نفسه إن امتحان البكالوريا سيعقد في الفترة من 16 إلى 20 يونيو ، وشهادة التعليم المتوسط  (BEM) من 9 إلى 11 يونيو ، بينما من المقرر إجراء امتحان السنة الخامسة الابتدائية في 29 مايو. ",
            education)

        val news10=News(R.drawable.news10,"26/04/2019","El Watan","الوطن",
            "Les Etats-Unis ont enregistré une croissance de 3,2 % au premier trimestre 2019", "نمت الولايات المتحدة بنسبة 3.2 ٪ في الربع الأول من عام 2019",


            "Les Cassandre en sont de nouveau pour leurs frais et l’Amérique de Donald Trump triomphe : la croissance de l’économie des Etats-Unis s’est établie à 3,2 % en rythme annuel au premier trimestre 2019. C’est beaucoup mieux que les + 2,5 % attendus par les experts interrogés par le Wall Street Journal.\n" +
                    "\n" +
                    "Le chiffre publié vendredi 26 avril est certes provisoire ; il peut encore être révisé. Il n’empêche, il confirme que le « shutdown », la fermeture provisoire de l’administration fédérale au début de l’année, a occupé le Landerneau à Washington mais il n’a pas affecté l’économie des cinquante Etats.",
            "عادت كاساندراس لنفقاتها وانتصار دونالد ترامب في أمريكا: كان نمو الاقتصاد الأمريكي 3.2 ٪ على أساس سنوي في الربع الأول من عام 2019. إنه أفضل بكثير من + 2.5 ٪ المتوقعة من قبل خبراء قابلتهم صحيفة وول ستريت جورنال.\n" +
                    "\n" +
                    "الرقم المنشور الجمعة 26 أبريل مؤقت بالتأكيد. لا يزال من الممكن تنقيحها. ومع ذلك ، فهو يؤكد أن \"الإغلاق\" ، وهو الإغلاق المؤقت للإدارة الفيدرالية في بداية العام ، احتل Landerneau في واشنطن لكنه لم يؤثر على اقتصاد الولايات الخمسين.",
            economie)

        val news11=News(R.drawable.news11,"26/04/2019","El Watan","الوطن",
            "Interpellés pour vol à l'étalage, deux hommes découverts en possession de 160 pots de Nutella", "تم القبض على رجلين لقيامهما بسرقة السرقة ، ووجدا بحوزتهما 160 وعاء من نوتيلا",


            "Les policiers de la commune d'Arras, dans le Pas-de-Calais, ont fait une drôle de découverte. Mercredi 24 avril, deux hommes ont été interpellés à la sortie d'un supermarché Lidl dans lequel ils venaient de dérober plusieurs bouteilles d'alcool, pour un montant global estimé à 150 euros, rapporte La Voix du Nord.\n" +
                    "\n" +
                    "Au cours de leur enquête, les policiers ont par ailleurs découvert que les deux suspects étaient en possession de 160 pots de pâte à tartiner Nutella, ainsi que de faux papiers d'identité et de faux chèques, a indiqué le parquet d'Arras.\n" +
                    "\n" +
                    "Les deux hommes, qui ont été placés en garde à vue, n'ont pas expliqué dans l'immédiat l'origine de leur marchandise, ni comment et où ils souhaitaient l'écouler.",
            "قامت شرطة بلدة أراس ، في با دو كاليه ، باكتشاف غريب. الأربعاء 24 أبريل ، تم القبض على رجلين عند الخروج من سوبر ماركت Lidl حيث كان عليهما سرقة عدة زجاجات من الكحول ، بمبلغ إجمالي يقدر بـ 150 يورو ، وفقًا لتقارير La Voix du Nord.\n" +
                    "\n" +
                    "وخلال التحقيق معهم ، اكتشفت الشرطة أيضًا أن المشتبه بهما كانا بحوزتهما 160 جرة من نوتيلة منتشرة ، بالإضافة إلى أوراق هوية مزورة وشيكات مزورة ، حسبما ذكر مكتب المدعي العام في أراس.\n" +
                    "\n" +
                    "لم يشرح الرجلان ، اللذان تم احتجازهما ، على الفور منشأ بضائعهم ، وكيف وأين يريدون التخلص منها.",
            divers)


        newsList.add(news1)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news4)
        newsList.add(news5)
        newsList.add(news6)
        newsList.add(news7)
        newsList.add(news8)
        newsList.add(news9)
        newsList.add(news10)
        newsList.add(news11)


        newsList.shuffle()

        categoriesList.add(politique)
        categoriesList.add(sport)
        categoriesList.add(societe)
        categoriesList.add(economie)
        categoriesList.add(sante)
        categoriesList.add(education)
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