package com.tenextractor.redefinablekeyboard.feature_config

import com.tenextractor.redefinablekeyboard.feature_config.combiners.BengaliCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.GreekCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.InuktitutCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.KannadaCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.KildinCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.KoreanCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.MalayalamCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.TamilCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.TeluguCombiner
import com.tenextractor.redefinablekeyboard.feature_config.combiners.TibetanCombiner
import com.tenextractor.redefinablekeyboard.feature_config.domain.KbLayout
import com.tenextractor.redefinablekeyboard.feature_config.domain.Key
import com.tenextractor.redefinablekeyboard.feature_config.domain.KeyWidth
import com.tenextractor.redefinablekeyboard.feature_config.domain.Layout
import com.tenextractor.redefinablekeyboard.feature_config.domain.SpecialKey
import com.tenextractor.redefinablekeyboard.feature_config.domain.SwipeKeys

fun bottomRow(comma: String, space: String, period: String, bottomRowKey: Key? = null): List<Key> {
    return if (bottomRowKey != null) {
        listOf(
            Key(text = "", label = "\uD83C\uDF10\uFE0E", width = KeyWidth.FractionWidth(.1F),
                specialKey = SpecialKey.LAYOUTCYCLE,
                swipeKeys = SwipeKeys(
                    up = Key(text = "", label = "\uD83C\uDF10\uFE0E≡", specialKey = SpecialKey.LAYOUTPOPUP),
                    left = Key(text = "", label = "<\uD83C\uDF10\uFE0E", specialKey = SpecialKey.LAYOUTLEFT),
                    right = Key(text = "", label = "\uD83C\uDF10\uFE0E>", specialKey = SpecialKey.LAYOUTRIGHT)
                )),
            Key(comma, width = KeyWidth.FractionWidth(.1F),
                swipeKeys = SwipeKeys(left = Key("„"), right = Key("“"))),
            bottomRowKey,
            Key(space, label = if (space == " ") "␣" else space, width = KeyWidth.FractionWidth(.25F),
                specialKey = SpecialKey.SPACE),
            Key("'", width = KeyWidth.FractionWidth(.1F),
                swipeKeys = SwipeKeys(up = Key("\""), left = Key("«"), right = Key("»"))),
            Key(period, width = KeyWidth.FractionWidth(.1F),
                swipeKeys = SwipeKeys(up = Key("?"), down = Key("!"), right = Key("—"))),
            Key(text = "", label = "⏎", width = KeyWidth.FractionWidth(.15F), specialKey = SpecialKey.ENTER)
        )
    } else listOf(
        Key(comma, width = KeyWidth.FractionWidth(.1F),
            swipeKeys = SwipeKeys(left = Key("„"), right = Key("“"))),
        Key(text = "", label = "\uD83C\uDF10\uFE0E", width = KeyWidth.FractionWidth(.1F),
            specialKey = SpecialKey.LAYOUTCYCLE,
            swipeKeys = SwipeKeys(
                up = Key(text = "", label = "\uD83C\uDF10\uFE0E≡", specialKey = SpecialKey.LAYOUTPOPUP),
                left = Key(text = "", label = "<", specialKey = SpecialKey.LAYOUTLEFT),
                right = Key(text = "", label = ">", specialKey = SpecialKey.LAYOUTRIGHT)
            )),
        Key(space, label = if (space == " ") "␣" else space, width = KeyWidth.FractionWidth(.3F), specialKey = SpecialKey.SPACE),
        Key("'", width = KeyWidth.FractionWidth(.1F),
            swipeKeys = SwipeKeys(up = Key("\""), left = Key("«"), right = Key("»"))),
        Key(period, width = KeyWidth.FractionWidth(.1F),
            swipeKeys = SwipeKeys(up = Key("?"), down = Key("!"), right = Key("—"))),
        Key(text = "", label = "⏎", width = KeyWidth.FractionWidth(.15F), specialKey = SpecialKey.ENTER)
    )
}
fun shiftKey(weight: Float): Key {
    return Key(text = "", label = "⌃", width = KeyWidth.WeightWidth(weight), specialKey = SpecialKey.SHIFT /*moveToLayer = 3*/)
}
fun unShiftKey(weight: Float): Key {
    return Key(text = "", label = "⌄", width = KeyWidth.WeightWidth(weight), specialKey = SpecialKey.UNSHIFT)
}
fun backSpaceKey(weight: Float, rightToLeft: Boolean = false): Key {
    return Key(text = "", label = if (rightToLeft) "⌦" else "⌫", width = KeyWidth.WeightWidth(weight),
        specialKey = SpecialKey.BACKSPACE)
}
fun symbolsKey1(width: KeyWidth = KeyWidth.FractionWidth(.15F)): Key {
    return Key(text = "", label = "?12", width = width, moveToLayer = 1)
}
val symbolsKey2 = Key(text = "", label = "={", moveToLayer = 2)
val alphabetKey = Key(text = "", label = "AB", width = KeyWidth.FractionWidth(.15F), moveToLayer = 0)
val zwnjKey = Key(text = "‌", label = "‹|›", width = KeyWidth.FractionWidth(.1F))

val symbols1 = """
1 2 3 4 5 6 7 8 9 0
! @ # $ % ^ & * ( )
" - : ; ¤ + ? /
""".trim()
val symbols2 = """
~ ` | • √ π ÷ × § ∆
£ ¢ € ¥ ¿ ° = { } \
< > _ © ® ™ ✓ [ ]
""".trim()

val inBuiltSimpleLayoutsString = """
Abkhaz
ӷ қ ҟ ԥ ҭ ҳ ҷ ҿ ә
ҵ ц у к е н г ш ӡ з х
ф ы в а п р о л д ж ҽ
џ ч с м и т ь б ҩ

Albanian
q w e r t z u i o p
a s d f g h j k l ë
y x c v b n m ç

Albanian(PC)
q w e r t z u i o p ç
a s d f g h j k l ë
y x c v b n m

Altai
ё ј ҥ ӧ ӱ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Amis
q w e r t y u i o p
a s d f g h j k l ^
z x c v b n m

Arapaho
3 é í ó ú
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Bashkir
ё ә ө ҡ ғ ҫ ҙ һ ү ң ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Belarusian (Latin)
ź ž ś š ć č ŭ ĺ ł ń 
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Berber/Tamazight (AZERTY)
č ẓ ɛ ṛ ṭ ɣ ǧ ḥ ř ṣ
a z e r t y u i o p
q s d f g h j k l m
w x c v b n ḍ

Berber/Tamazight (QWERTY)
č ẓ ɛ ṛ ṭ ɣ ǧ ḥ ř ṣ
q w e r t y u i o p
a s d f g h j k l ḍ
z x c v b n m

Brahui (Latin)
á ş đ ŕ ŧ ģ ú í ń ź
q w e r t y u i o p
a s d f g h j k l ļ
z x c v b n m

Breton
â ñ ê ü û î ô ù
a z e r t y u i o p
q s d f g h j k l m
w x c v b n

Bulgarian (ЯВЕРТЪ)
я в е р т ъ у и о п ч
а с д ф г х й к л ш щ
з ь ц ж б н м ю

Bulgarian (УЕИШЩ)
ѝ у е и ш щ к с д з ц
ь я а о ж г т н в м ч
ю й ъ ф х п р л б

Buryat (Mongolia)
е щ һ ъ ю
ф ц у ж э н г ш ү з к
й ы б ө а х р о л д п
я ч ё с м и т ь в

Buryat (Russia)
ё ө ү һ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Cahuilla
č ʷ kʷ l̃ ñ ŋ š xʷ ɂ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Carrier/Dakelh (Latin)
s̱ t͟s ẕ d͟z
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Catalan
à ç é ï ŀ ü ú í ó ò
q w e r t y u i o p
a s d f g h j k l è
z x c v b n m

Caucasian
ё « Ӏ » ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chamorro
q w e r t y u i o p
a s d f g h j k l ñ
z x c v b n m å

Chechen (Latin)
q̇ ä ə ċ ç ç̇ ü ġ ö ẋ ŋ
q w e r t y u i o p ş
a s d f g h j k l ƶ
z x c v b n m

Cheyenne
á ȧ â é ė ê ó ȯ ô š
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Chukchi
ё ӄ ԓ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chulym
ё ғ ҥ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Chuvash
ё ӑ ӗ ҫ ӳ ъ - ! ? "
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Comanche
ʔ e̱ a̱ ʉ ʉ̱ u̱ i̱ o̱
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Coptic
ⲋ ϥ ϩ ϫ ϭ ϯ ⳁ ◌̀
ϧ ϣ ⲉ ⲣ ⲧ ⲩ ⲑ ⲓ ⲟ ⲡ
ⲁ ⲥ ⲇ ⲫ ⲅ ⲏ ⲝ ⲕ ⲗ
ⲍ ⲭ ⲯ ⲱ ⲃ ⲛ ⲙ

Cree/Atikamekw (Latin)
â ê š s̀ ð û î ô
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Czech
ď ě š č ř ž ý á í é ň
q w e r t z u i o p ú
a s d f g h j k l ů ó
y x c v b n m

Dagbani
q w e r t y u i o p ɣ
a s d f g h j k l ɔ ɛ
z x c v b n m ʒ ŋ

Danish(/Norwegian)
q w e r t y u i o p å
a s d f g h j k l æ ø
z x c v b n m

Dinka
ä ɛ ë ɛ̈ ɣ ŋ ɔ ï ö ɔ̈
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Dungan
ё ә җ ң ү ў ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Efik
q w e r t y u i o p
a s d f g h j k l ñ
z x c v b n m ọ

Enets
ё ԑ ӊ о̂ ˮ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

English (Colemak)
q w f p g j l u y ;
a r s t d h n e i o
z x c v b k m

Esperanto
ŝ ĝ e r t ŭ u i o p
a s d f g h j k l ĵ
z ĉ c v b n m ĥ

Estonian
q w e r t y u i o p ü
a s d f g h j k l ö ä
z x c v b n m õ

Even
ё ӈ ө ӫ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Evenki
ё̄ э̄
ё а̄ ӯ ӣ е̄ ӈ ы̄ о̄ я̄ ю̄ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Ewe
ɖ ɛ ƒ ɣ ŋ ɔ ʋ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Farefare/Frafra
ŋ ã ɛ ẽ ĩ õ ʋ ɩ ɔ ũ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Faroese
ð æ ø ý ú í ó
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Finnish/Swedish
q w e r t y u i o p å
a s d f g h j k l ö ä
z x c v b n m

Fulani/Fulfulde (All)
ɓ ɗ ɠ ɲ ƴ ñ n̰ ŋ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Fulani/Fulfulde (Maasina)
q w e r t y u i o p ƴ
a s d f g h j k l ɗ ɓ
z x c v b n m ŋ ɲ

Garo
q w e r t y u i o p
a s d f g h j k l ·
z x c v b n m

German
q w e r t z u i o p ü
a s d f g h j k l ö ä
y x c v b n m ß

German (Neo 2)
x v l c w k h g f q ß
u i a e o s n r t d y
ü ö ä p z b m j

German (Switzerland)
q w e r t z u i o p ü
a s d f g h j k l ö ä
y x c v b n m

Gĩkũyũ/Kikuyu
q w e r t y u i o p
a s d f g h j k l ĩ
z x c v b n m ũ

Gitxsan
q w e r t y u i o p
a s d f g h j k l ḵ
z x c v b n m x̱

Guaymí/Ngäbere
q w e r t y u i o p ü
a s d f g h j k l ñ ä
z x c v b n m ö

Hausa
q w e r t y u i o p ƙ
a s d f g h j k l ɗ
z x c v b n m ɓ ƴ

Hawaiian
ā ē ī ō ū ʻ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Ho-Chunk (Wisconsin)
ą ǧ į š ų ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Hungarian
á é í ó ö ő ú ü ű -
q w e r t z u i o p
a s d f g h j k l
y x c v b n m

Icelandic
á æ é ð þ ý ú í ó ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Ingrian/Izhorian
q w e r t y u i o p š
a s d f g h j k l ö ä
z x c v b n m ь ž

Innu-Aimun
ā ī ū ᵘ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Interslavic (Cyrillic)
љ њ е р т ы у и о п ш
а с д ф г х й к л ч ж
з є ц в б н м

Interslavic (Latin)
q w e r t y u i o p š
a s d f g h j k l č ž
z x c v b n m ě

Iñupiaq
ġ ḷ ł ł̣ ñ ŋ r̂
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Italian
à ç è é ì ò ó ù
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Javanese (Latin)
q w e r t y u i o p
a s d f g h j k l é
z x c v b n m è

Kanuri
q w e r t y u i o p
a s d f g h j k l ǝ
z x c v b n m ɍ

Karakalpak (Cyrillic)
ё ў ү қ ә ң ғ ө ҳ ? ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Karelian
č š ž ä ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Kashubian
ą ã ë é ń ô ù ó ò ż
q w e r t y u i o p
a s d f g h j k l ł
z x c v b n m

Kazakh (Cyrillic)
ё ә і ң ғ ү ұ қ ө һ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Ket
ё ӄ ә ӈ ӷ ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Khakas
ё ғ і ң ӧ ӱ ӌ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Khasi
q w e r t y u i o p
a s d f g h j k l ñ
z x c v b n m ï

Koryak
ё вʼ гʼ ӄ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Kurdish (Kurmanji) (Latin)
q w e r t y u i o p û
a s d f g h j k l ê î
z x c v b n m ç ş

Kwak'wala
ʼ a̱ ł g̱ t̓ k̓ ḵ ḵ̓  x̱ p̓
q w e r t y u i o p
a s d f g h j k l
z x c v b n m ž

Kyrgyz
ё ү ң ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Lakota
á č é ǧ ȟ ŋ ú í ó š
q w e r t y u i o p
a s d f g h j k l
z x c v b n m ž

Laz (Latin)
ç ǧ ǩ p̌ ş t‌̌ ž ʒ ǯ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Lithuanian
ą č ę ė į š ų ū ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Ludic/Veps
č š ž ü ä ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Macedonian
љ њ е р т ѕ у и о п ш
а с д ф г х й к л ч ќ
з џ ц в б н м ѓ ж

Mansi (Northern) (Big)
ё̄ ъ
ё ы̄ ӯ а̄ е̄ ӈ о̄ я̄ ю̄ ӣ э̄
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Māori
ā ē ī ō ū
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Mari (All)
ё ӓ ӹ ө ӫ ҥ ӧ ӱ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Marshallese
ā l‌̧ m̧ n‌̧ n̄ o̧ ō
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Massachusett/Wampanoag
q w e r t y u i o p ô
a s d f g h j k l â 8
z x c v b n m

Menominee
ā ē æ ǣ ö ū ī ō
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Mi'kmaq
á é í ó ú ɨ ꞌ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Mongolian (Cyrillic)
е щ « » ъ ю
ф ц у ж э н г ш ү з к
й ы б ө а х р о л д п
я ч ё с м и т ь в

Nanai
ё ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Navajo (Big)
á ą ą́ é ę ę́ í į į́ ó ǫ
q w e r t y u i o p ǫ́
a s d f g h j k l ł
z x c v b n m

Nenets
ё ʼ ˮ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nganasan
ё з̌ ˮ ӈ ө ү ә ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nisga'a
ḵ w̓ x̱ l̓ y̓ n̓ m̓
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Nivkh
ё ӷ ў ӄ ғ ӈ ӻ р̌ ӽ ӿ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Nuxalk
q w e r t y u i o p
a s d f g h j k l 7
z x c v b n m

O'odham
ḏ ḍ ñ ŋ ṣ :
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Odun/Forest Yukaghir
ё җ қ ә ҥ ҕ ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Ossetian
ё « ӕ » ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Polish
ą ć ę ł n ó ś ź ż
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Romanian
q w e r t y u i o p ă
a s d f g h j k l ș ț
z x c v b n m î â

Rumantsch
à é ê è ï ö ü
q w e r t z u i o p
a s d f g h j k l
y x c v b n m

Russian
ё ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Russian (Phonetic)
ё ъ
я ш е р т ы у и о п ч
а с д ф г х й к л ж э
з ь ц в б н м ю щ

Rusyn (All)
ё ӯ ӱ ы о̄ ґ о̂ ї ъ
й ц у к е н г ш щ з х
ф і в а п р о л д ж є
я ч с м и т ь б ю

Sámi (Inari)
á â ä č đ ŋ š ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Sámi (Kildin) (Big)
ё̄ ӊ ӈ о̄ ҏ ӯ э̄ ӭ ю̄ я̄ ҍ
ё а̄ ӓ е̄ һ ӣ ј ҋ ӆ ӎ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Sámi (Lule)
q w e r t y u i o p å
a s d f g h j k l á ä
z x c v b n m ŋ

Sámi (Northern)
á č đ ŋ š ŧ ž
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Sámi (Pite)
á đ ŋ ŧ å ä
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Sámi (Skolt)
â č ʒ ǯ đ ǩ š ž å ä ʹ
q w e r t y u i o p õ
a s d f g h j k l ǧ ǥ
z x c v b n m ŋ ž

Sámi (Southern)
q w e r t y u i o p å
a s d f g h j k l ö æ
z x c v b n m ï

Sámi (Ume)
á đ å ŧ ŋ ü ï ö ä
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Serbo-Croatian (Cyrillic)
љ њ е р т з у и о п ш
а с д ф г х й к л ч ћ
џ ц в б н м ђ ж

Serbo-Croatian (Latin)
q w e r t z u i o p š
a s d f g h j k l č ć
y x c v b n m ž đ

Setswana
q w e r t y u i o p š
a s d f g h j k l ô ê
z x c v b n m

Shuswap
q̓ w̓ n̓ r̓ t̓ y̓ g̓ k̓ m̓ p̓
q w e r t y u i o p
a s d f g h j k l l̓
z x c v b n m 7

Siberian Tatar
ё ө ү ҡ ә ң ғ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Slovak (Big)
ď ĺ ň ó ô ŕ ú
ľ š č ť ž ý á í é ä
q w e r t z u i o p
a s d f g h j k l
y x c v b n m

Slovene
q w e r t z u i o p š
a s d f g h j k l č ž
y x c v b n m

Spanish (Big)
á é ñ ¿ ¡ ú í ó ü
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Squamish
ḵ m̓ n̓ y̓ l̓ x̱ 7
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Sundanese (Latin)
q w e r t y u i o p
a s d f g h j k l é
z x c v b n m

Tajik
ё ғ ӯ ъ
й қ у к е н г ш ҳ з х
ф ҷ в а п р о л д ж э
я ч с м и т ӣ б ю

Tatar (Cyrillic)
ё һ ү җ ә ң ө ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Tłı̨chǫ (Big)
à ą ą̀ è ę ę̀ ì ı̨ į̀ ò ǫ
q w e r t y u ı o p ǫ̀
a s d f g h j k l ł i
z x c v b n m

Tofa
ё і ү қ ә ң ғ ө һ ҷ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Tsimshian (Coast)
ḵ ẅ a̰ ɫ ü g̲
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Tswa
q w e r t y u i o p ṅ
a s d f g h j k l ŝ ẑ
z x c v b n m

Tumbuka
q w e r t y u i o p
a s d f g h j k l ŵ
z x c v b n m

Turkmen
ä ş ç ž ý ü ň ö
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Udege (Petersburg)
ё ԝ ә ӡ њ ӈ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Ute
q w e r t y u i o p
a s d f g h j k l ɵ
z x c v b n m ʉ

Uzbek (Cyrillic)
ё ғ ҳ ъ
й ц у к е н г ш ў з х
ф қ в а п р о л д ж э
я ч с м и т ь б ю

Uzbek (Latin)
q w e r t y u i o p oʻ
a s d f g h j k l gʻ ʼ
z x c v b n m

Venda
ḓ ḽ ṋ ṅ ṱ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Votic
š ž ü ä ö õ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Wadul/Tundra Yukaghir
ё ҕ ҥ ө ԝ ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Welsh
â ê î ô û ŵ ŷ
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Wolof
é ë à ñ ŋ ó
q w e r t y u i o p
a s d f g h j k l
z x c v b n m

Yaghnobi
ё ғ ԝ ӯ ъ
й қ у к е н г ш ҳ з х
ф ҷ в а п р о л д ж э
я ч с м и т ӣ б ю

Yakut
ё нь дь ҥ ҕ ө һ ү ъ
й ц у к е н г ш щ з х
ф ы в а п р о л д ж э
я ч с м и т ь б ю

Zazaki
ç ê ğ ş û î
q w e r t y u i o p
a s d f g h j k l
z x c v b n m
""".trim()

val layouts = listOf(
    Layout(
        name = "Arabic (101)",
        layout = """
            ض ص ث ق ف غ ع ه خ ح ج
            ش س ي ب ل ا ت ن م ك ط
            ذ ء ر ئ ة و ز ظ د
        """.trimIndent(),
        capsLayer = """
            ◌َ ◌ً ◌ُ ◌ٌ لإ إ ‘ ÷ × ؛ <
            ◌ِ ◌ٍ ] [ ◌ٰ أ ـ , / : "
            ◌ّ ◌ْ آ ى ’ ؤ . ؟ >
        """.trimIndent(),
        comma = "،",
        rightToLeft = true
    ),
    Layout(
        name = "Armenian",
        layout = """
            « ՝ ՜ ՞ ՛ . »
            է թ փ ձ ջ և ր չ ճ ժ
            ք ո ե ռ տ ը ւ ի օ պ խ
            ա ս դ ֆ գ հ յ կ լ ծ
            զ ղ ց վ բ ն մ շ
        """.trimIndent(),
        period = "։"
    ),
    Layout(
        name = "Assamese (Phonetic)",
        layout = """
            শ্ ণ্ য়্ ড়্ ঔ ঐ ঊ ঈ ◌ঁ ষ্
            আ ট্ এ ৰ্ ত্ য্ উ ই ও প্
            অ চ্ দ্ ফ্ গ্ হ্ ◌ং ক্ ল্
            জ্ স্ ড্ ৱ্ ব্ ন্ ম্
        """.trimIndent(),
        capsLayer = """
            ৳ ণ্ ৡ ঢ়্ " ? ৠ ! ◌ঁ ষ্
            ঽ ঠ্ ঌ ৰ্ থ্ ঞ্ ঋ ই ও প্
            অ্যা ছ্ ধ্ ফ্ ঘ্ হ্ ◌ঃ খ্ ল্
            ঝ্ স্ ঢ্ ভ্ ভ্ ঙ্ ম্
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey.copy(label = "◌্"),
        combiner = BengaliCombiner,
        swipeList = listOf(
            Pair("ত্", SwipeKeys(up = Key("থ্"), down = Key("ৎ")))
        )
    ),
    Layout(
        name = "Azerbaijani (Cyrillic)",
        layout = """
            ј ү у к е н г ш һ з х
            ф ы в а п р о л д ж ҝ
            ә ч с м и т ғ б ө
        """.trimIndent(),
        bottomRowKey = Key(text = "ҹ", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Azerbaijani (Latin)",
        layout = """
            ə ç ğ ş ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ə Ç Ğ Ş Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Belarusian (Cyrillic)",
        layout = """
            й ц у к е н г ш ў з х
            ф ы в а п р о л д ж э
            я ч с м і т ь б ю
        """.trimIndent(),
        bottomRowKey = Key(text = "ё", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Bengali (InScript)",
        layout = """
            ◌ৌ ◌ৈ ◌া ◌ী ◌ূ ব হ গ দ জ ড
            ◌ো ◌ে ◌্ ◌ি ◌ু প র ক ত চ ট
            ◌় ◌ং ম ন ◌ৃ ল স শ য়
        """.trimIndent(),
        capsLayer = """
            ঔ ঐ আ ঈ ঊ ভ ঙ ঘ ধ ঝ ঢ
            ও এ ◌্ ই উ ফ ৎ খ থ ছ ঠ
            ঞ ◌ঁ ণ ঃ ঋ . ॥ ষ য
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Bengali (Phonetic)",
        layout = """
            শ্ ণ্ য়্ ড়্ ঔ ঐ ঊ ঈ ◌ঁ ষ্
            আ ট্ এ র্ ত্ য্ উ ই ও প্
            অ স্ দ্ ফ্ গ্ হ্ জ্ ক্ ল্
            ◌ং ড্ চ্ ভ্ ব্ ন্ ম্
        """.trimIndent(),
        capsLayer = """
            ৳ ণ্ ৡ ঢ়্ " ? ৠ ! ◌ঁ ষ্
            ঽ ঠ্ ঌ ৰ্ থ্ ঞ্ ঋ ই ও প্
            অ্যা স্ ধ্ ফ্ ঘ্ হ্ ঝ্ খ্ ল্
            ◌ঃ ঢ্ ছ্ ₹ ৱ্ ঙ্ ম্
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey.copy(label = "◌্"),
        combiner = BengaliCombiner,
        swipeList = listOf(
            Pair("ত্", SwipeKeys(up = Key("থ্"), down = Key("ৎ")))
        )
    ),
    Layout(
        name = "Blackfoot (Syllabics)",
        layout = """
            ᑉ ᐤ ᐨ ᘁ ᐢ ᐡ ᔈ ᐟ ᐠ ᙿ
            ᖲ ᑲ ᒪ ᖾ ᒐ ᖺ ᓴ ᔭ ᖶ ᐧ
            ᖱ ᑯ ᒧ ᖽ ᒍ ᖹ ᓱ ᔪ ᖵ ᐦ
            ᖰ ᑭ ᒥ ᖼ ᒋ ᖸ ᓯ ᔨ ᖴ ᑊ
            ᖳ ᑫ ᒣ ᖿ ᒉ ᖻ ᓭ ᔦ ᖷ
        """.trimIndent(),
        hasShift = false,
        period = "᙮"
    ),
    Layout(
        name = "Brahui (Arabic)",
        layout = """
            ض ص غ ڑ ٹ ث ح ئ ظ ط ذ
            ق و ع ر ت ے ء ی ہ پ ڷ
            آ ا س ڈ د ف گ ھ ج ک ل
            ز ش خ چ ط ب ں ن م
        """.trimIndent(),
        capsLayer = """
            ١ ٢ ٣ ٤ ٥ ٦ ٧ ٨ ٩ ٠ ,
            ◌ْ ؤ ◌ٰ ڑ ٹ ◌َ ئ ◌ِ ۃ ◌ُ ن٘
            إ أ ص ڈ ؟ ◌ّ غ ح ض خ ◌ٔ
            ذ ژ ـ ث ظ . ؛ ۓ ◌٘
        """.trimIndent(),
        comma = "،",
        period = "۔",
        rightToLeft = true
    ),
    Layout(
        name = "Burmese/Myanmar",
        layout = """
            ဈ ဝ ဋ ◌ုံ ော ဪ ရ ဂ ဟ ၏
            ဆ တ န မ အ ပ က င သ စ
            ‌ေ ◌ျ ◌ိ ◌် ◌ါ ◌့ ြ ◌ု ◌ူ ◌း
            ဖ ထ ခ လ ဘ ည ◌ာ ယ
        """.trimIndent(),
        capsLayer = """
            ၁ ၂ ၃ ၄ ၅ ၆ ၇ ၈ ၉ ၀
            ဍ ဏ္ဍ ဣ ၎င်း ဤ ၌ ဥ ၍ ဿ ဏ
            ဗ ◌ှ ◌ီ ◌္ ◌ွ ◌ံ ◌ဲ ဒ ဓ ဏ္ဌ
            ဇ ဌ ဃ ဠ ဎ ဉ ဦ ဧ
        """.trimIndent()
    ),
    /*Layout(
        name = "Cree (Western syllabics)",
        layout = """
            ᕽ ᐤ ᐁ ᕒ ᐟ ᕀ ᐆ ᐃ ᐅ ᑊ
            ᐊ ᐢ ᙾ f g ᐦ ᐄ ᐠ ᓬ
            ᐋ ᐝ ᐨ c v ᐣ ᒼ
        """.trimIndent(),
        combiner = InuktitutCombiner
    ),*/
    Layout(
        name = "Crimean Tatar (Latin)",
        layout = """
            ç ğ ş ñ ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ç Ğ Ş Ñ Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Czech (Small)",
        layout = """
            q w e r t y u i o p
            a s d f g h j k l ´
            z x c v b n m ˇ
        """.trimIndent(),
        otherLayers = listOf("""
            q w é ŕ t́ ý ú í ó ṕ
            á ś d́ f ǵ h j ḱ ĺ ´
            ź x ć v b ń ḿ ˇ
        """.trimIndent(), """
            q w ě ř ť y ǔ ǐ ǒ p
            ǎ š ď f ǧ ȟ ǰ ǩ ľ ´
            ž x č v b ň m ˇ
        """)
    ),
    Layout(
        name = "Dënesųłinë́ (Latin)",
        layout = """
            ą ę ë ę̈ ł ų į ǫ ´
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ą́ ę́ ë́ ę̈́ ł ų́ į́ ǫ́ ´
            q w é r t y ú í ó p
            á s d f g h j k l
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("´"),
        swipeList = listOf(
            Pair("a", SwipeKeys(Key("á"))),
            Pair("ą", SwipeKeys(Key("ą́"))),
            Pair("e", SwipeKeys(Key("é"))),
            Pair("ë", SwipeKeys(Key("ë́"))),
            Pair("ę", SwipeKeys(Key("ę́"))),
            Pair("ę̈", SwipeKeys(Key("ę̈́"))),
            Pair("i", SwipeKeys(Key("í"))),
            Pair("į", SwipeKeys(Key("į́"))),
            Pair("o", SwipeKeys(Key("ó"))),
            Pair("ǫ", SwipeKeys(Key("ǫ́"))),
            Pair("u", SwipeKeys(Key("ú"))),
            Pair("ų", SwipeKeys(Key("ų́"))),
        )
    ),
    Layout(
        name = "Dhivehi",
        layout = """
            ◌ާ ށ ◌ޭ ޅ ޑ ޏ ◌ޫ ◌ީ ◌ޯ ޱ
            ◌ް އ ◌ެ ރ ތ ޔ ◌ު ◌ި ◌ޮ ޕ
            ◌ަ ސ ދ ފ ގ ހ ޖ ކ ލ
            ޒ ޓ ޗ ވ ބ ނ މ
        """.trimIndent(),
        capsLayer = """
            ◌ާ ށ ◌ޭ ޅ ޑ ޏ ◌ޫ ◌ީ ◌ޯ ؟
            ޤ ޢ ◌ޭ ޜ ޓ ޠ ◌ޫ ◌ީ ◌ޯ ÷
            ◌ާ ށ ޑ ﷲ ޣ ޙ ޛ ޚ ޅ
            ޡ ޘ ޝ ޥ ޞ ޏ ޟ
        """.trimIndent()
    ),
    Layout(
        name = "English (Dvorak)",
        layout = """
            ' , . p y f g c r l
            a o e u i d h t n s
            j k x b m w v z
        """,
        bottomRowKey = Key(text = "q", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Erzya (Latin)",
        layout = """
            ´ˇ ä ě ś ť ž ü š ö č
            q w e r t y u i o p
            a s d f g h j k l ń
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ´ˇ ä ě ś ť ž ű š ő č
            q w é ŕ ť ý ú í ó ṕ
            á ś ď f́ ǵ h j ḱ ĺ ń
            ź x ć v́ b́ ń ḿ
        """.trimIndent()),
        moveLayerKeys = listOf("´ˇ")
    ),
    /*
    Layout(
        name = "Farsi/Persian",
        layout = """
            ض ص ث ق ف غ ع ه خ ح ج
            ش س ی ب ل ا ت ن م ک گ
            ظ ط ژ ز ر ذ د پ و چ
        """.trimIndent(),
        hasShift = false,
        rightToLeft = true,
        bottomRowKey = zwnjKey,
        swipeList = listOf(
            Pair("ا", SwipeKeys(Key("آ"), Key(""), Key("")))
        )
    ),*/
    Layout(
        name = "French (AZERTY)",
        layout = """
            à é è ê ç â û ¨ ô œ
            a z e r t y u i o p
            q s d f g h j k l m
            w x c v b n ù
        """.trimIndent(),
        otherLayers = listOf("""
            à é è ê ç â û ¨ ô œ
            ä z ë r t ÿ ü ï ö p
            q s d f g h j k l m
            w x c v b n ù
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "French (BÉPO)",
        layout = """
            â ù ô û ¨ æ œ
            b é p o è v d l j z w
            a u i e c t s r n m ç
            ê à y x k q g h f
        """.trimIndent(),
        otherLayers = listOf("""
            â ù ô û ¨ æ œ
            b é p ö è v d l j z w
            ä ü ï ë c t s r n m ç
            ê à ÿ x k q g h f
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "French (QWERTY)",
        layout = """
            à û è ê ç â ù ¨ ô œ
            q w e r t y u i o p
            a s d f g h j k l é
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            à û è ê ç â ù ¨ ô œ
            q w ë r t ÿ ü ï ö p
            ä s d f g h j k l é
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "French (QWERTZ)",
        layout = """
            à û è ê ç â ù ¨ ô œ
            q w e r t z u i o p
            a s d f g h j k l é
            y x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            à û è ê ç â ù ¨ ô œ
            q w ë r t z ü ï ö p
            ä s d f g h j k l é
            ÿ x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("¨")
    ),
    Layout(
        name = "Gagauz",
        layout = """
            ä ê ç ţ ş ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ä Ê Ç Ţ Ş Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Georgian (ქწერტყ)",
        layout = """
            „ ჭ ღ თ შ ჟ ძ ჩ “
            ქ წ ე რ ტ ყ უ ი ო პ
            ა ს დ ფ გ ჰ ჯ კ ლ
            ზ ხ ც ვ ბ ნ მ
        """.trimIndent(),
        capsLayer = """
            „ ჭ ღ თ შ ჟ ძ ჩ “
            ქ ჭ ე ღ თ ყ უ ი ო პ
            ა შ დ ფ გ ჰ ჟ კ ლ
            ძ ხ ჩ ვ ბ ნ მ
        """.trimIndent()
    ),
    Layout(
        name = "Georgian (ღჯუკენ)",
        layout = """
            ღ ჯ უ კ ე ნ გ შ ზ ხ ც
            ფ ძ ვ თ ა პ რ ო ლ დ ჟ
            ჭ ჩ ყ ს მ ი ტ ქ ბ ჰ
        """.trimIndent(),
        hasShift = false,
        bottomRowKey = Key(text = "წ", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Greek",
        layout = """
            ε ρ τ υ θ ι ο π ´
            α σ δ φ γ η ξ κ λ
            ζ χ ψ ω β ν μ
        """.trimIndent(),
        otherLayers = listOf("""
            έ ρ τ ύ θ ί ό π ´
            ά σ δ φ γ ή ξ κ λ
            ζ χ ψ ώ β ν μ
        """.trimIndent()
        ),
        moveLayerKeys = listOf("´"),
        swipeList = listOf(
            Pair("α", SwipeKeys(Key("ά"))),
            Pair("ε", SwipeKeys(Key("έ"), Key(";"))),
            Pair("η", SwipeKeys(Key("ή"))),
            Pair("ι", SwipeKeys(Key("ί"), Key("ϊ"), Key("ΐ"))),
            Pair("ο", SwipeKeys(Key("ό"))),
            Pair("σ", SwipeKeys(Key("ς"))),
            Pair("υ", SwipeKeys(Key("ύ"), Key("ϋ"), Key("ΰ"))),
            Pair("ω", SwipeKeys(Key("ώ")))
        ),
        combiner = GreekCombiner
    ),
    Layout(
        name = "Guarani",
        layout = """
            ʼ ã ẽ g̃ ñ ỹ ũ ĩ õ ´
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ʼ ã́ ẽ́ g̃ ñ ỹ́ ṹ ĩ́ ṍ ´
            q w é r t ý ú í ó p
            á s d f g h j k l
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("´")
    ),
    Layout(
        name = "Gujarati (InScript)",
        layout = """
            ◌ૉ ◌ૅ ◌ૃ ◌ૄ
            ◌ૌ ◌ૈ ◌ા ◌ી ◌ૂ બ હ ગ દ જ ડ
            ◌ો ◌ે ◌્ ◌િ ◌ુ પ ર ક ત ચ ટ
            ◌઼ ◌ં મ ન વ લ સ શ ય
        """.trimIndent(),
        capsLayer = """
            ઑ ઍ ઋ ૠ
            ઔ ઐ આ ઈ ઊ ભ ઙ ઘ ધ ઝ ઢ
            ઓ એ અ ઇ ઉ ફ ર ખ થ છ ઠ
            ઞ ઁ ણ ન વ ળ ॥ ષ ◌ઃ
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Hebrew",
        layout = """
            ' - ק ר א ט ו ן ם פ
            ש ד ג כ ע י ח ל ך ף
            ז ס ב ה נ מ צ ת ץ
        """.trimIndent(),
        hasShift = false,
        rightToLeft = true,
        swipeList = listOf(
            Pair("'", SwipeKeys(Key("׳"), Key("״"))),
            Pair("ו", SwipeKeys(Key("וֹ"))),
            Pair("ב", SwipeKeys(Key("בּ"))),
            Pair("ג", SwipeKeys(Key("גּ"))),
            Pair("ד", SwipeKeys(Key("דּ"))),
            Pair("כ", SwipeKeys(Key("כֿ"))),
            Pair("ך", SwipeKeys(Key("ךּ"))),
            Pair("ף", SwipeKeys(Key("ףּ")))
        )
    ),
    Layout(
        name = "Hindi (Alternate)",
        layout = """
            ट ◌ौ ◌े र त य ◌ु ◌ि ◌ो प ◌ी
            ◌ा स द ◌ू ग ह ज क ल ◌ै ◌ं
            श ड च व ब न म ◌्
        """.trimIndent(),
        capsLayer = """
            ठ औ ए ◌ृ थ ञ उ इ ओ फ ई
            आ ऋ ध ऊ घ ङ झ ख ळ ऐ ◌ँ
            ष ढ छ ◌ः भ ण ़ अ
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Hindi (InScript)",
        layout = """
            ◌ॅ ऍ ◌ॉ ऑ ृ ऋ ़ ञ
            ◌ौ ◌ै ◌ा ◌ी ◌ू ब ह ग द ज ड
            ◌ो ◌े ◌् ि ◌ु प र क त च ट
            ◌ँ ◌ं म न व ल स श य
        """.trimIndent(),
        capsLayer = """
            ◌ॅ ऍ ◌ॉ ऑ ृ ऋ ़ ञ
            औ ऐ आ ई ऊ भ ङ घ ध झ ढ
            ओ ए अ इ उ फ ऱ ख थ छ ठ
            ◌ः ◌़ ण ऩ ऴ ळ ॥ ष य़
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Ho",
        layout = """
            𑣿 𑣛 𑣛 𑣆 𑣊 𑣍 𑣐
            𑣄 𑣒 𑣈 𑣜 𑣕 𑣅 𑣃 𑣂 𑣉 𑣘
            𑣁 𑣞 𑣔 𑣑 𑣋 𑣙 𑣎 𑣌 𑣚
            𑣀 𑣝 𑣏 𑣟 𑣗 𑣓 𑣖
        """.trimIndent(),
        capsLayer = """
            𑣿 𑢻 𑢻 𑢦 𑢪 𑢭 𑢰
            𑢤 𑢲 𑢨 𑢼 𑢵 𑢥 𑢣 𑢢 𑢩 𑢸
            𑢡 𑢾 𑢴 𑢱 𑢫 𑢹 𑢮 𑢬 𑢺
            𑢠 𑢽 𑢯 𑢿 𑢷 𑢳 𑢶
        """.trimIndent()
    ),
    Layout(
        name = "Inuktitut (ᖃᓂᐅᔮᖅᐸᐃᑦ)",
        layout = """
            ᖅ ᖕ ᐁ ᕐ ᑦ ᐄ ᐅ ᐃ ᐆ ᑉ
            ᐊ ᔅ ᖦ ᖮ ᒡ ᕻ ᔾ ᒃ ᓪ
            ᐋ 𑪺 ᕼ ᕝ ᖯ ᓐ ᒻ
        """.trimIndent(),
        capsLayer = """
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        bottomRowKey = Key("\uD806\uDEB4"),
        combiner = InuktitutCombiner
    ),
    Layout(
        name = "Kannada (InScript)",
        layout = """
            ◌ೄ ◌ಃ ಞ
            ◌ೌ ◌ೈ ◌ಾ ◌ೀ ◌ೂ ಬ ಹ ಗ ದ ಜ ಡ
            ◌ೋ ◌ೇ ◌್ ◌ಿ ◌ು ಪ ರ ಕ ತ ಚ ಟ
            ◌ೊ ◌ೆ ◌ಂ ಮ ನ ವ ಲ ಸ ಯ
        """.trimIndent(),
        capsLayer = """
            ೠ ◌ಃ ಞ
            ಔ ಐ ಆ ಈ ಊ ಭ ಙ ಘ ಧ ಝ ಢ
            ಓ ಏ ಅ ಇ ಉ ಫ ಱ ಖ ಥ ಛ ಠ
            ಒ ಎ ೞ ಣ ◌ೃ ಋ ಳ ಶ ಷ
        """.trimIndent(),
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Kannada (Phonetic)",
        layout = """
            ಶ್ ಣ್ ಏ ಳ್ ಔ ಐ ಊ ಈ ಓ ಷ್
            ಆ ಟ್ ಎ ರ್ ತ್ ಯ್ ಉ ಇ ಒ ಪ್
            ಅ ಸ್ ದ್ ಫ್ ಗ್ ಹ್ ಜ್ ಕ್ ಲ್
            ಂ ಡ್ ಚ್ ವ್ ಬ್ ನ್ ಮ್
        """.trimIndent(),
        capsLayer = """
            ₹ ಣ್ ೡ ೞ್ " ? ೠ ! ಓ ಁ
            ಽ ಠ್ ಌ ಱ್ ಥ್ ಞ್ ಋ ಇ ಒ ಫ್
            ಅ ಸ್ ಧ್ ಫ಼್ ಘ್ ಙ್ ಝ್ ಖ್ ಲ್
            ಜ಼್ ಢ್ ಛ್ ಃ ಭ್ ೝ ಮ್
        """.trimIndent(),
        bottomRowKey = zwnjKey,
        combiner = KannadaCombiner
    ),
    Layout(
        name = "Karakalpak (Latin)",
        layout = """
            á ǵ ı ń ó ú
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Á Ǵ Í Ń Ó Ú
            Q W E R T Y U I O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Kazakh (Latin)",
        layout = """
            ä ı ñ ğ ü ū ş ö ç
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ä I Ñ Ğ Ü Ū Ş Ö Ç
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Komi",
        layout = """
            ё і ӧ ъ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        decoupleRows = listOf(0),
        swipeList = listOf(
            Pair("й", SwipeKeys(Key("ј"))),
            Pair("н", SwipeKeys(Key("ԋ"))),
            Pair("з", SwipeKeys(up = Key("ԅ"), down = Key("ԇ"))),
            Pair("о", SwipeKeys(Key("ӧ"))),
            Pair("л", SwipeKeys(Key("ԉ"))),
            Pair("ж", SwipeKeys(Key("җ"))),
            Pair("д", SwipeKeys(up = Key("ԁ"), down = Key("ԃ"))),
            Pair("с", SwipeKeys(Key("ԍ"))),
            Pair("и", SwipeKeys(Key("і"))),
            Pair("т", SwipeKeys(Key("ԏ")))
        )
    ),
    Layout(
        name = "Komi (Molodtsov)",
        layout = """
            ԃ ԉ ԋ ԅ ԇ
            ј ц у к е н г ш щ з х
            ф ы в а п р о л ԁ ж җ
            ԍ ч с м і т ԏ б ӧ
        """.trimIndent(),
        decoupleRows = listOf(0),
        swipeList = listOf(
            Pair("ј", SwipeKeys(Key("й"))),
            Pair("е", SwipeKeys(up = Key("э"), down = Key("ё"))),
            Pair("ԁ", SwipeKeys(Key("д"))),
            Pair("җ", SwipeKeys(Key("э"))),
            Pair("ԍ", SwipeKeys(Key("я"))),
            Pair("і", SwipeKeys(Key("и"))),
            Pair("ԏ", SwipeKeys(up = Key("ь"), down = Key("ъ"))),
            Pair("ӧ", SwipeKeys(Key("ю")))
        )
    ),
    Layout(
        name = "Korean (Big)",
        layout = """
            ㅃ ㅉ ㄸ ㄲ ㅆ - ? " ㅒ ㅖ
            ㅂ ㅈ ㄷ ㄱ ㅅ ㅛ ㅕ ㅑ ㅐ ㅔ
            ㅁ ㄴ ㅇ ㄹ ㅎ ㅗ ㅓ ㅏ ㅣ
            ㅋ ㅌ ㅊ ㅍ ㅠ ㅜ ㅡ
        """.trimIndent(),
        capsLayer = """
            ㅃ ㅉ ㄸ ㄲ ㅆ - ? " ㅒ ㅖ
            ㅃ ㅉ ㄸ ㄲ ㅆ ㅛ ㅕ ㅑ ㅒ ㅖ
            ㅁ ㄴ ㅇ ㄹ ㅎ ㅗ ㅓ ㅏ ㅣ
            ㅋ ㅌ ㅊ ㅍ ㅠ ㅜ ㅡ
        """.trimIndent(),
        currency = "₩",
        combiner = KoreanCombiner
    ),
    Layout(
        name = "Kurdish (Arabic)",
        layout = """
            ع ش ڕ غ ڵ ێ چ ؟
            ق و ە ر ت ی ئ ح ۆ پ
            ا س د ف گ ه ژ ک ل
            ز خ ج ڤ ب ن م
        """.trimIndent(),
        capsLayer = """
            ع ش ڕ غ ڵ ێ چ ؟
            ` وو ي ڕ ط ێ ء ع ؤ ث
            آ ش ذ إ غ ه أ ك ڵ
            ض ص چ ظ ى ة ـ
        """.trimIndent(),
        rightToLeft = true
    ),
    Layout(
        name = "Latin International",
        layout = """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌́ w é ŕ t́ ý ú í ó ṕ
            á ś d́ f ǵ h j ḱ ĺ
            ź x ć v b ń ḿ
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̀ ẁ è r t ỳ ù ì ò p
            à s d f g h j k l
            z x c v b ǹ m
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̂ ŵ ê r ṱ ŷ û î ô p
            â ŝ ḓ f ĝ ĥ ĵ k ḽ
            ẑ x ĉ v b n m
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̄ ◌̱ ē ṟ ṯ ȳ ū ī ō p
            ā s ḏ ꞙ ḡ ẖ ɟ ḵ ḻ
            ẕ ǣ c v ḇ ṉ m
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̆ ȗ ĕ ȓ t ȋ ŭ ĭ ŏ p
            ă s d f ğ ḫ j k l
            z x c v m̆ n̆ m̐
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̃ w ẽ ᵲ ᵵ ỹ ũ ĩ õ ᵱ
            ã ᵴ ᵭ ᵮ g h j k ɫ
            ᵶ x c v b ñ ᵯ
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̈ ẅ ë r ẗ ÿ ü ï ö p
            ä s d f g ḧ j k l
            z æ c v b n m
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̇ ẇ ė ṙ ṫ ẏ u ı ȯ ṗ
            ȧ ṡ ḋ ḟ ġ ḣ ȷ k l
            ż ẋ ċ v ḃ ṅ ṁ
        """.trimIndent(), """
            ˚ ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̣ ẉ ẹ ṛ ṭ ỵ ụ ị ọ p
            ạ ṣ ḍ f g ḥ j ḳ ḷ
            ẓ x c ṿ ḅ ṇ ṃ
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˘ ˜ ¸
            ◌̌ w ě ř ť y ǔ ǐ ǒ p
            ǎ š ď f ǧ ȟ ǰ ǩ ľ
            ž ǯ č v b ň m
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̧ ę ȩ ŗ ţ y ų į ǫ p
            ą ş ḑ f ģ ḩ j ķ ļ
            z x ç v b ņ m̧
        """.trimIndent(), """
            . ¯ ´ ˋ ˙ ˆ ¨ ˇ ˜ ¸
            ◌̊ ◌̥ ɛ r̥ ʈ y ů ɪ ɔ ʊ
            å ʃ ɗ f ɠ ɦ ʄ ƙ ɭ
            ʒ χ æ v ɓ ɲ ɱ
        """.trimIndent()
        ),
        moveLayerKeys = listOf(
            "´", "ˋ", "ˆ", "¯", "˘", "˜", "¨", "˙", ".", "ˇ", "¸", "˚"
        ),
        swipeList = listOf(
            Pair(".", SwipeKeys(up = Key("!"), down = Key("1"),
                right = Key(text = "", label = "˚", moveToLayer = 14))),
            Pair("¯", SwipeKeys(up = Key("@"), down = Key("2"), right = Key("-"),
                left = Key("_"))),
            Pair("´", SwipeKeys(up = Key("#"), down = Key("3"))),
            Pair("ˋ", SwipeKeys(up = Key("$"), down = Key("4"), right = Key("`"))),
            Pair("˙", SwipeKeys(up = Key("%"), down = Key("5"))),
            Pair("ˆ", SwipeKeys(up = Key("^"), down = Key("6"), left = Key("<"), right = Key(">"))),
            Pair("¨", SwipeKeys(up = Key("&"), down = Key("7"), left = Key(";"), right = Key(":"))),
            Pair("ˇ", SwipeKeys(up = Key("*"), down = Key("8"))),
            Pair("˜", SwipeKeys(up = Key("("), down = Key("9"), right = Key("~"))),
            Pair("¸", SwipeKeys(up = Key(")"), down = Key("0"))),

            Pair("q", SwipeKeys(up = Key("ʔ"), down = Key("ʕ"), left = Key("ʢ"),
                right = Key("ʡ"))),
            Pair("w", SwipeKeys(up = Key("ɯ"), down = Key("ɰ"))),
            Pair("e", SwipeKeys(up = Key("ə"))),
            Pair("r", SwipeKeys(up = Key("r̥̄"), down = Key("ṝ"), left = Key("ɹ"),
                right = Key("ɾ"))),
            Pair("ṛ", SwipeKeys(up = Key("ɽ", moveToLayer = 0),
                down = Key("ɻ", moveToLayer = 0),
                left = Key("ʀ", moveToLayer = 0),
                right = Key("ʁ", moveToLayer = 0))),
            Pair("t", SwipeKeys(up = Key("θ"), down = Key("ŧ"))),
            Pair("u", SwipeKeys(up = Key("ʉ"))),
            Pair("i", SwipeKeys(up = Key("|"), left = Key("\\"), right = Key("/"),
                down = Key("ɨ"))),
            Pair("o", SwipeKeys(up = Key("ɤ"), down = Key("ɔ"), left = Key("œ"),
                right = Key("ø"))),

            Pair("a", SwipeKeys(left = Key("ɑ"), down = Key("ɐ"), right = Key("ɒ"),
                up = Key("ʌ"))),
            Pair("s", SwipeKeys(up = Key("ʃ"), left = Key("ɕ"), right = Key("ʂ"))),
            Pair("d", SwipeKeys(up = Key("ð"), down = Key("đ"))),
            Pair("f", SwipeKeys(up = Key("ɸ"), left = Key("+"), right = Key("="))),
            Pair("g", SwipeKeys(up = Key("ɣ"), down = Key("ɢ"))),
            Pair("h", SwipeKeys(left = Key("("), right = Key(")"), up = Key("ħ"),
                down = Key("ʜ"))),
            Pair("j", SwipeKeys(down = Key("ʝ"), up = Key("ʲ"),
                left = Key("["), right = Key("]"))),
            Pair("k", SwipeKeys(left = Key("{"), right = Key("}"))),
            Pair("l", SwipeKeys(up = Key("l̥̄"), down = Key("ḹ"), left = Key("ɮ"),
                right = Key("ɬ"))),
            Pair("ḷ", SwipeKeys(up = Key("ꞎ", moveToLayer = 0),
                down = Key("ɺ"))),

            Pair("z", SwipeKeys(up = Key("ʒ"), left = Key("ʑ"), right = Key("ʐ"))),
            Pair("x", SwipeKeys(down = Key("χ"))),
            Pair("c", SwipeKeys(left = Key("ˀ"), right = Key("ˤ"))),
            Pair("b", SwipeKeys(up = Key("β"), down = Key("ʙ"))),
            Pair("v", SwipeKeys(up = Key("ʋ"), down = Key("ⱱ"), left = Key("<"),
                right = Key(">"))),
            Pair("n", SwipeKeys(up = Key("ⁿ"), down = Key("ŋ"), left = Key("ɴ"),
                right = Key("ɳ")))
        )
    ),
    Layout(
        name = "Lao",
        layout = """
            ຢ ຟ ໂ ຖ ◌ຸ ◌ູ ຄ ຕ ຈ ຂ ຊ ◌ໍ
            ◌ົ ໄ ຳ ພ ະ ◌ິ ◌ີ ຮ ນ ຍ ບ ລ
            ◌ັ ຫ ກ ດ ເ ◌້ ◌່ າ ສ ວ ງ “
            ຜ ປ ແ ອ ◌ຶ ◌ື ທ ມ ໃ ຝ
        """.trimIndent(),
        capsLayer = """
            ໑ ໒ ໓ ໔ ◌໌ ◌ຼ ໕ ໖ ໗ ໘ ໙ ◌ໍ່
            ◌ົ້ ໐ ຳ້ _ + ◌ິ້ ◌ີ້ ຣ ໜ ຽ ຫຼ ”
            ◌ັ້ ; . , : ◌໊ ◌໋ ! ? % = “
            ₭ ( ຯ @ ◌ຶ້ ◌ື້ ໆ ໝ $ )
        """.trimIndent()
    ),
    Layout(
        name = "Latvian (Big)",
        layout = """
            ā č ē ģ ķ ņ ū ī š ž
            q w e r t y u i o p
            a s d f g h j k l ļ
            z x c v b n m
        """.trimIndent(),
        swipeList = listOf(
            Pair("a", SwipeKeys(up = Key("ā"))),
            Pair("c", SwipeKeys(up = Key("č"))),
            Pair("e", SwipeKeys(up = Key("ē"))),
            Pair("g", SwipeKeys(up = Key("ģ"))),
            Pair("k", SwipeKeys(up = Key("ķ"))),
            Pair("l", SwipeKeys(up = Key("ļ"))),
            Pair("n", SwipeKeys(up = Key("ņ"))),
            Pair("o", SwipeKeys(up = Key("ō"))),
            Pair("r", SwipeKeys(up = Key("ŗ"))),
            Pair("s", SwipeKeys(up = Key("š"))),
            Pair("u", SwipeKeys(up = Key("ū"))),
            Pair("z", SwipeKeys(up = Key("ž"))),
        )
    ),
    Layout(
        name = "Laz (Mkhedruli)",
        layout = """
            ჶ ჭ თ შ ღ ჟ ძ ჩ
            ქ წ ე რ ტ ყ უ ი ო პ
            ა ს დ ფ გ ჰ ჯ კ ლ
            ჲ ზ ხ ც ვ ბ ნ მ
        """.trimIndent(),
        hasShift = false
    ),
    Layout(
        name = "Lisu",
        layout = """
            ꓥ ꓭ ꓷ ꓸ ꓹ ꓺ ꓻ ꓼ ꓽ ˍ
            ꓘ ꓛ ꓱ ꓤ ꓕ ꓞ ꓵ ꓨ ꓩ ꓒ
            ꓯ ꓪ ꓰ ꓣ ꓔ ꓬ ꓴ ꓲ ꓳ ꓑ
            ꓮ ꓢ ꓓ ꓝ ꓖ ꓧ ꓙ ꓗ ꓡ ꓶ
            ꓜ ꓫ ꓚ ꓦ ꓐ ꓠ ꓟ
        """.trimIndent(),
        capsLayer = """
            ꓥ ꓭ ꓷ ꓸ ꓹ ꓺ ꓻ ꓼ ꓽ ˍ
            ꓘ ꓛ ꓱ ꓤ ꓕ ꓞ ꓵ ꓨ ꓩ ꓒ
            ꓯ ꓪ ꓱ ꓤ ꓕ ꓻ ꓵ ꓹꓼ ˍ ꓒ
            ꓯ ꓽ ꓷ ꓞ ꓨ ꓺ ꓩ ꓘ ꓶ ꓶ
            ꓹ ꓸ ꓛ ꓥ ꓭ - ꓸꓼ
        """.trimIndent(),
        comma = "꓾",
        period = "꓿"
    ),
    Layout(
        name = "Livonian",
        layout = """
            ¯ ä ḑ ŗ ț ņ š ȯ õ ž
            q w e r t y u i o p
            a s d f g h j k l ļ
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ¯ ǟ ḑ ŗ ț ņ š ȱ ȭ ž
            q w ē r t ȳ ū ī ō p
            ā s d f g h j k l ļ
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("¯"),
        swipeList = listOf(
            Pair("a", SwipeKeys(up = Key("ā"), left = Key("ä"), right = Key("ǟ"))),
            Pair("ä", SwipeKeys(Key("ǟ"))),
            Pair("c", SwipeKeys(up = Key("č"))),
            Pair("d", SwipeKeys(Key("ḑ"))),
            Pair("e", SwipeKeys(up = Key("ē"))),
            Pair("g", SwipeKeys(up = Key("ģ"))),
            Pair("k", SwipeKeys(up = Key("ķ"))),
            Pair("l", SwipeKeys(up = Key("ļ"))),
            Pair("n", SwipeKeys(up = Key("ņ"))),
            Pair("o", SwipeKeys(up = Key(text = "ō"), left = Key(text = "ö"),
                right = Key(text = "ȫ"), down = Key(text = "ǭ"))),
            Pair("õ", SwipeKeys(Key("ȭ"))),
            Pair("ȯ", SwipeKeys(Key("ȱ"))),
            Pair("r", SwipeKeys(up = Key("ŗ"))),
            Pair("s", SwipeKeys(up = Key("š"))),
            Pair("u", SwipeKeys(left = Key(text = "ü"), right = Key(text = "ǖ"))),
            Pair("y", SwipeKeys(up = Key(text = "ȳ"))),
            Pair("z", SwipeKeys(up = Key("ž"))),
        )
    ),
    Layout(
        name = "Luxembourgish",
        layout = """
            ´ ` ^ ¨ ~ ë é ä
            q w e r t z u i o p
            a s d f g h j k l
            y x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ´ ` ^ ¨ ~ ë é ä
            q w é r t z ú í ó p
            á s d f g h j k l
            ý x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~ ë é ä
            q w è r t z ù ì ò p
            à s d f g h j k l
            ỳ x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~ ë é ä
            q w ê r t z û î ô p
            â s d f g h j k l
            ŷ x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~ ë é ä
            q w ë r t z ü ï ö p
            ä s d f g h j k l
            ÿ x c v b n m
        """.trimIndent(), """
            ´ ` ^ ¨ ~ ë é ä
            q w ẽ r t z ũ ĩ õ p
            ã s d f g h j k l
            ỹ x c v b ñ m
        """.trimIndent()),
        moveLayerKeys = "´ ` ^ ¨ ~".split(' ')
    ),
    Layout(
        name = "Malayalam (InScript)",
        layout = """
            ◌ൃ ◌ൄ ◌ഃ ർ ഞ ൽ ൿ ൾ റ്റ
            ◌ൌ ◌ൈ ◌ാ ◌ീ ◌ൂ ബ ഹ ഗ ദ ജ ഡ
            ◌ോ ◌േ ◌് ◌ി ◌ു പ ര ക ത ച ട
            ◌ൊ ◌െ ◌ം മ ന വ ല സ യ
        """.trimIndent(),
        capsLayer = """
            ഋ ൠ ◌ഃ ർ ഞ ൽ ൿ ൾ റ്റ
            ഔ ഐ ആ ഈ ഊ ഭ ങ ഘ ധ ഝ ഢ
            ഓ ഏ അ ഇ ഉ ഫ റ ഖ ഥ ഛ ഠ
            ഒ എ ൺ ണ ൻ ഴ ള ശ ഷ
        """.trimIndent(),
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Malayalam (Phonetic)",
        layout = """
            ശ് ൺ ഏ ർ ഔ ഐ ഊ ഈ ഓ ഷ് ‍ഞ്
            ആ ട് എ ര് ത് യ് ഉ ഇ ഒ പ് ങ്
            അ സ് ദ് ് ഗ് ഹ് ജ് ക് ൽ ൾ ം
            ഴ് ഡ് ച് വ് ബ് ൻ മ്
        """.trimIndent(),
        capsLayer = """
            ₹ ഩ് ൡ ർ " ? ൠ ! ഓ ഷ് ഞ്
            ഽ ഠ് ഌ ര് ഥ് ഞ് ഋ ഇ ഒ ഫ് ങ്
            അ സ് ധ് ് ഘ് ങ് ഝ് ഖ് ൽ ൾ ം
            ഺ് ഢ് ഛ് ഃ ഭ് ൻറ മ്
        """.trimIndent(),
        combiner = MalayalamCombiner
    ),
    Layout(
        name = "Maltese",
        layout = """
            ċ ġ ħ ż `
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ċ ġ ħ ż `
            q w è r t y ù ì ò p
            à s d f g h j k l
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("`")
    ),
    Layout(
        name = "Mansi (Northern) (Small)",
        layout = """
            ё ¯ ӈ ъ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё̄ ¯ ӈ ъ
            й ц ӯ к е̄ н г ш щ з х
            ф ы̄ в а̄ п р о̄ л д ж э̄
            я̄ ч с м ӣ т ь б ю̄
        """.trimIndent()),
        moveLayerKeys = listOf("¯"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Māori (Small)",
        layout = """
            q w e r t y u i o p
            a s d f g h j k l ¯
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            q w ē r t ȳ ū ī ō p
            ā s d f g h j k l
            z x c v b n m
        """.trimIndent()),
        moveLayerKeys = listOf("¯")
    ),
    Layout(
        name = "Mingrelian",
        layout = """
            ჸ ჭ თ შ ღ ჟ ძ ჩ ჷ
            ქ წ ე რ ტ ყ უ ი ო პ
            ა ს დ ფ გ ჰ ჯ კ ლ
            ჲ ზ ხ ც ვ ბ ნ მ
        """.trimIndent(),
        hasShift = false
    ),
    Layout(
        name = "Mizo",
        layout = """
            â ê î ô û ṭ
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        decoupleRows = listOf(0),
        swipeList = listOf(
            Pair("a", SwipeKeys(Key("ả"), Key("ą"), Key("ạ"))),
            Pair("â", SwipeKeys(Key("á"), Key("ä"), Key("à"))),
            Pair("e", SwipeKeys(Key("ẻ"), Key("ę"), Key("ẹ"))),
            Pair("ê", SwipeKeys(Key("é"), Key("ë"), Key("è"))),
            Pair("i", SwipeKeys(Key("ỉ"), Key("į"), Key("ị"))),
            Pair("î", SwipeKeys(Key("í"), Key("ï"), Key("ì"))),
            Pair("o", SwipeKeys(Key("ỏ"), Key("ǫ"), Key("ọ"))),
            Pair("ô", SwipeKeys(Key("ó"), Key("ö"), Key("ò"))),
            Pair("u", SwipeKeys(Key("ủ"), Key("ų"), Key("ụ"))),
            Pair("û", SwipeKeys(Key("ú"), Key("ü"), Key("ù")))
        ),
    ),
    Layout(
        name = "Mohawk",
        layout = """
            ì á è é ṉ ù ú í ó :
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        swipeList = listOf(
            Pair("a", SwipeKeys(Key("á"), down = Key("à"))),
            Pair("e", SwipeKeys(Key("é"), down = Key("è"))),
            Pair("i", SwipeKeys(Key("í"), down = Key("ì"))),
            Pair("n", SwipeKeys(Key("ṉ"))),
            Pair("o", SwipeKeys(Key("ó"), down = Key("ò"))),
            Pair("u", SwipeKeys(Key("ú"), down = Key("ù"))),
        )
    ),
    /*Layout(
        name = "Mongolian (Mongolian Script)",
        layout = """
            ᠸ ᠧ ᠿ ᠾ ᠻ ᡀ ᡂ ᠩ
            ᠴ ᠣ ᠡ ᠷ ᠲ ᠶ ᠦ ᠢ ᠥ ᠫ
            ᠠ ᠰ ᠳ ᠹ ᠭ ᠬ ᠵ ᠺ ᠯ
            ᡁ ᠽ ᠱ ᠼ ᠤ ᠪ ᠨ ᠮ
        """.trimIndent(),
        hasShift = false
    ),*/
    Layout(
        name = "Mro/Mru",
        layout = """
            𖩡 𖩢 𖩣 𖩤 𖩥 𖩦 𖩧 𖩨 𖩩 𖩠
            𖩈 𖩗 𖩘 𖩓 𖩀 𖩂 𖩑 𖩊 𖩝 𖩐 𖩙
            𖩆 𖩔 𖩅 𖩇 𖩁 𖩉 𖩜 𖩌 𖩍 𖩚 𖩛
            𖩖 𖩕 𖩒 𖩋 𖩞 𖩄 𖩏 𖩃 𖩎
        """.trimIndent(),
        hasShift = false,
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Naskapi (Syllabics)",
        layout = """
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᐟ ᐤ
            ᐅ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᑴ :
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᑶ ᔋ
            ᐎ ᓪ ᓗ ᓕ ᓚ ᕐ ᕈ ᕆ ᕋ ᒄ ?
            ᐊ ᐸ ᑕ ᑲ ᒪ ᓇ ᓴ ᔭ ᒐ ᑾ
        """.trimIndent(),
        otherLayers = listOf("""
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᐟ ᐤ
            ᐖ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᑴ :
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᑶ ᔋ
            ᐎ ᓪ ᓗ ᓕ ᓚ ᕐ ᕈ ᕆ ᕋ ᒄ ?
            ᐛ ᑈ ᑥ ᒂ ᒺ ᓏ ᔄ ᔽ ᒠ ᑾ
        """.trimIndent(), """
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᐟ ᐤ
            ᐅ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᑴ :
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᑶ ᔋ
            ᐎ ᓪ ᓗ ᓕ ᓚ ᕐ ᕈ ᕆ ᕋ ᔊ ?
            ᐊ ᔌ ᔍ ᔎ ᒪ ᓇ ᓴ ᔭ ᔏ ᑾ
        """.trimIndent()),
        moveLayerKeys = listOf(":", "ᔋ"),
        hasShift = false
    ),
    Layout(
        name = "Odia (InScript)",
        layout = """
            ◌ृ ◌ୄ ◌ଃ
            ◌ୌ ◌ୈ ◌ା ◌ୀ ◌ୂ ବ ହ ଗ ଦ ଜ ଡ
            ◌ୋ ◌େ ◌୍ ◌ି ◌ୁ ପ ର କ ତ ଚ ଟ
            ◌଼ ◌ଂ ମ ନ ୱ ଲ ସ ଶ ୟ
        """.trimIndent(),
        capsLayer = """
            ଋ ୠ ◌ଃ
            ଔ ଐ ଆ ଈ ଊ ଭ ଙ ଘ ଧ ଝ ଢ
            ଓ ଏ ଅ ଇ ଉ ଫ ଡ଼ ଖ ଥ ଛ ଠ
            ଞ ◌ଁ ଣ ଢ଼ ଵ ଳ ॥ ଷ ଯ
        """.trimIndent(),
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Ojibwe (Syllabics a-finals)",
        layout = """
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᔥ ᐤ
            ᐅ ᐳ ᑐ ᑯ ᒧ ᓄ ᓱ ᔪ ᒍ ᔓ ᐧ
            ᐃ ᐱ ᑎ ᑭ ᒥ ᓂ ᓯ ᔨ ᒋ ᔑ ˙
            ᐁ ᐯ ᑌ ᑫ ᒣ ᓀ ᓭ ᔦ ᒉ ᔐ ?
            ᐊ ᐸ ᑕ ᑲ ᒪ ᓇ ᓴ ᔭ ᒐ ᔕ
        """.trimIndent(),
        otherLayers = listOf("""
            ᐦ ᑉ ᑦ ᒃ ᒻ ᓐ ᔅ ᔾ ᒡ ᔥ ᐤ
            ᐆ ᐴ ᑑ ᑰ ᒨ ᓅ ᓲ ᔫ ᒎ ᔔ ᐧ
            ᐄ ᐲ ᑏ ᑮ ᒦ ᓃ ᓰ ᔩ ᒌ ᔒ ˙
            ᐁ ᐯ ᑌ ᑫ ᒣ ᓀ ᓭ ᔦ ᒉ ᔐ ?
            ᐋ ᐹ ᑖ ᑳ ᒫ ᓈ ᓵ ᔮ ᒑ ᔖ
        """.trimIndent()),
        moveLayerKeys = listOf("˙"),
        hasShift = false
    ),
    Layout(
        name = "Portuguese",
        layout = """
            ç ´ ` ^ ¨ ~
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ç ´ ` ^ ¨ ~
            q w é ŕ t́ ý ú í ó ṕ
            á ś d́ f ǵ h j ḱ ĺ
            ź x ć v b ń ḿ
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q ẁ è r t ỳ ù ì ò p
            à s d f g h j k l
            z x c v b ǹ m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q ŵ ê r ṱ ŷ û î ô p
            â ŝ ḓ f ĝ ĥ ĵ k ḽ
            ẑ x ĉ v b n m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q ẅ ë r ẗ ÿ ü ï ö p
            ä s d f g ḧ j k l
            z x c v b n m
        """.trimIndent(), """
            ç ´ ` ^ ¨ ~
            q w ẽ ᵲ ᵵ ỹ ũ ĩ õ ᵱ
            ã ᵴ ᵭ ᵮ g h j k ɫ
            ᵶ x c v b ñ ᵯ
        """.trimIndent()),
        decoupleRows = listOf(0),
        moveLayerKeys = "´ ` ^ ¨ ~".split(' ')
    ),
    Layout(
        name = "Punjabi (Gurmukhi) (InScript)",
        layout = """
            ◌ੌ ◌ੈ ◌ਾ ◌ੀ ◌ੂ ਬ ਹ ਗ ਦ ਜ ਡ
            ◌ੋ ◌ੇ ◌੍ ◌ਿ ◌ੁ ਪ ਰ ਕ ਤ ਚ ਟ
            ◌਼ ◌ੰ ਮ ਨ ਵ ਲ ਸ ਸ਼ ਯ
        """.trimIndent(),
        capsLayer = """
            ਔ ਐ ਆ ਈ ਊ ਭ ਙ ਘ ਧ ਝ ਢ
            ਓ ਏ ਅ ਇ ਉ ਫ ੜ ਖ ਥ ਛ ਠ
            ਞ ਂ ਣ ੲ ੳ ਲ਼ ॥ ੱ ?
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Punjabi (Shahmukhi)",
        layout = """
            ض ص غ ڑ ٹ ث ح ئ ظ ط ݨ
            ق و ع ر ت ے ء ی ہ پ لؕ
            آ ا س ڈ د ف گ ھ ج ک ل
            ز ش خ چ ط ب ں ن م
        """.trimIndent(),
        capsLayer = """
            ١ ٢ ٣ ٤ ٥ ٦ ٧ ٨ ٩ ٠ ن٘
            ◌ْ ؤ ◌ٰ ڑ ٹ ◌َ ئ ◌ِ ۃ ◌ُ ,
            إ أ ص ڈ ؟ ◌ّ غ ح ض خ ◌ٔ
            ذ ژ ـ ث ظ . ؛ ۓ ◌٘
        """.trimIndent(),
        comma = "،",
        period = "۔",
        rightToLeft = true
    ),
    Layout(
        name = "Rusyn (Pannonian)",
        layout = """
            й ц у к е н г ш щ з х
            ф ї в а п р о л д ж є
            я ч с м и т ь б ю
        """.trimIndent(),
        bottomRowKey = Key(text = "ґ", width = KeyWidth.FractionWidth(.1F))
    ),
    Layout(
        name = "Saanich",
        layout = """
            Á W̱ Ⱥ Ŧ Ⱦ Ṯ Ȼ Í ₭ Ḵ Ḱ
            Q W E R T Y U I O P X̱
            A S D F G H J K L Ƚ Ś
            Z X C V B N M Ṉ Ć
        """.trimIndent(),
        capsLayer = """
            á w̱ ⱥ ŧ ⱦ ṯ ȼ í ꞣ ḵ ḱ
            q w e r t y u i o p x̱
            a s d f g h j k l ƚ ś
            z x c v b n m ṉ ć
        """.trimIndent()
    ),
    Layout(
        name = "Sámi (Kildin) (Small)",
        layout = """
            ё ј һ ¯, ӭ ӈ ӓ ъ ҍ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё̄ ј һ ¯, ӭ̄ ӈ ӓ̄ ъ ҍ
            ҋ ц ӯ к е̄ ӊ г ш щ з х
            ф ы̄ в а̄ п ҏ о̄ ӆ д ж э̄
            я̄ ч с ӎ ӣ т ь б ю̄
        """.trimIndent()),
        moveLayerKeys = listOf("¯,"),
        decoupleRows = listOf(0),
        swipeList = listOf(
            Pair("а", SwipeKeys(Key("а̄"))),
            Pair("ӓ", SwipeKeys(Key("ӓ̄"))),
            Pair("е", SwipeKeys(up = Key("е̄"), right = Key("ё̄"), down = Key("ё"))),
            Pair("ё", SwipeKeys(Key("ё̄"))),
            Pair("и", SwipeKeys(Key("ӣ"))),
            Pair("й", SwipeKeys(up = Key("ҋ"), down = Key("ј"))),
            Pair("л", SwipeKeys(Key("ӆ"))),
            Pair("м", SwipeKeys(Key("ӎ"))),
            Pair("н", SwipeKeys(up = Key("ӊ"), down = Key("ӈ"))),
            Pair("р", SwipeKeys(Key("ҏ"))),
            Pair("о", SwipeKeys(Key("о̄"))),
            Pair("у", SwipeKeys(Key("ӯ"))),
            Pair("х", SwipeKeys(Key("һ"))),
            Pair("ы", SwipeKeys(Key("ы̄"))),
            Pair("ь", SwipeKeys(Key("ҍ"))),
            Pair("э", SwipeKeys(Key("э̄"))),
            Pair("ӭ", SwipeKeys(Key("ӭ̄"))),
            Pair("ю", SwipeKeys(Key("ю̄"))),
            Pair("я", SwipeKeys(Key("я̄"))),
        )
    ),
    Layout(
        name = "Sámi (Kildin) 2",
        layout = """
            ё ј һ ¯, ӭ ӈ ӓ ъ ҍ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё̄ ј һ ¯, ӭ̄ ӈ ӓ̄ ъ ҍ
            ҋ ц ӯ к е̄ ӊ г ш щ з х
            ф ы̄ в а̄ п ҏ о̄ ӆ д ж э̄
            я̄ ч с ӎ ӣ т ь б ю̄
        """.trimIndent()),
        moveLayerKeys = listOf("¯,"),
        decoupleRows = listOf(0),
        bottomRowKey = Key(text = " ", label = "‹|›", width = KeyWidth.FractionWidth(.1F)),
        combiner = KildinCombiner,
        swipeList = listOf(
            Pair("а", SwipeKeys(Key("а̄"))),
            Pair("ӓ", SwipeKeys(Key("ӓ̄"))),
            Pair("е", SwipeKeys(up = Key("е̄"), right = Key("ё̄"), down = Key("ё"))),
            Pair("ё", SwipeKeys(Key("ё̄"))),
            Pair("и", SwipeKeys(Key("ӣ"))),
            Pair("й", SwipeKeys(up = Key("ҋ"), down = Key("ј"))),
            Pair("л", SwipeKeys(Key("ӆ"))),
            Pair("м", SwipeKeys(Key("ӎ"))),
            Pair("н", SwipeKeys(up = Key("ӊ"), down = Key("ӈ"))),
            Pair("р", SwipeKeys(Key("ҏ"))),
            Pair("о", SwipeKeys(Key("о̄"))),
            Pair("у", SwipeKeys(Key("ӯ"))),
            Pair("х", SwipeKeys(Key("һ"))),
            Pair("ы", SwipeKeys(Key("ы̄"))),
            Pair("ь", SwipeKeys(Key("ҍ"))),
            Pair("э", SwipeKeys(Key("э̄"))),
            Pair("ӭ", SwipeKeys(Key("ӭ̄"))),
            Pair("ю", SwipeKeys(Key("ю̄"))),
            Pair("я", SwipeKeys(Key("я̄"))),
        )
    ),
    Layout(
        name = "Santali",
        layout = """
            ᱚ ᱽ ᱹ ᱸ ᱺ ᱻ ᱼ
            ᱧ ᱣ ᱮ ᱨ ᱛ ᱭ ᱩ ᱤ ᱳ ᱯ
            ᱟ ᱥ ᱫ ᱝ ᱜ ᱷ ᱦ ᱡ ᱠ ᱞ
            ᱲ ᱰ ᱪ ᱶ ᱵ ᱱ ᱬ ᱢ ᱴ
        """.trimIndent(),
        hasShift = false
    ),
    Layout(
        name = "Selkup (Southern)",
        layout = """
            ҷ ӽ ъ
            ё и̇ ӱ ӄ ӓ ӈ ӷ ӧ ¯ җ ´
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ҷ ӽ ъ
            ё̄ и̇̄ ӱ̄ ӄ ӓ̄ ӈ ӷ ӧ̄ ¯ җ ´
            й ц ӯ к е̄ н г ш щ з х
            ф ы̄ в а̄ п р о̄ л д ж э̄
            я̄ ч с м ӣ т ь б ю̄
        """.trimIndent(), """
            ҷ ӽ ъ
            ё́ и̇́ ӱ́ ӄ ӓ́ ӈ ӷ ӧ́ ¯ җ ´
            й ц у́ к е́ н г ш щ з х
            ф ы́ в а́ п р о́ л д ж э́
            я́ ч с м и́ т ь б ю́
        """.trimIndent()),
        moveLayerKeys = listOf("¯", "´"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Shughni (Cyrillic)",
        layout = """
            ё а̄ у̊ ˇ ӗ в̌ ҙ ғ ӯ ъ
            й қ у к е н г ш ҳ з х
            ф ҷ в а п р о л д ж э
            я ч с м и т ӣ б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё а̄ у̊ ˇ ӗ в̌ ҙ ғ ӯ ъ
            й қ у к е н г̌ ш ҳ з х̌
            ф ҷ в̌ а п р о л д̌ ж э
            я ч с м и т̌ ӣ б ю
        """.trimIndent()),
        moveLayerKeys = listOf("ˇ"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Sindhi (Devanagari) (InScript)",
        layout = """
            ◌ॅ ◌ॉ ृ ़ ञ
            ◌ौ ◌ै ◌ा ◌ी ◌ू ब ह ग द ज ड
            ◌ो ◌े ◌् ि ◌ु प र क त च ट
            ◌ँ ◌ं म न व ल स श य
        """.trimIndent(),
        capsLayer = """
            ऍ ऑ ऋ ़ ॿ ञ ॻ ॼ ॾ
            औ ऐ आ ई ऊ भ ङ घ ध झ ढ
            ओ ए अ इ उ फ ऱ ख थ छ ठ
            ◌ः ◌़ ण ऩ ऴ ळ ॥ ष य़
        """.trimIndent(),
        period = "।",
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Sora",
        layout = """
            𑃧 𑃣 𑃝 𑃑 𑃜 𑃥 𑃤 𑃦 𑃛
            𑃢 𑃐 𑃔 𑃗 𑃕 𑃞 𑃠 𑃟 𑃘
            𑃨 𑃡 𑃓 𑃚 𑃒 𑃙 𑃖
        """.trimIndent(),
        hasShift = false,
    ),
    Layout(
        name = "Spanish (Small)",
        layout = """
            q w e r t y u i o p
            a s d f g h j k l ñ
            z x c v b n m
        """.trimIndent(),
        swipeList = listOf(
            Pair("a", SwipeKeys(Key("á"))),
            Pair("e", SwipeKeys(Key("é"))),
            Pair("i", SwipeKeys(Key("í"))),
            Pair("m", SwipeKeys(Key("¿"), down = Key("¡"))),
            Pair("n", SwipeKeys(Key("ñ"))),
            Pair("o", SwipeKeys(Key("ó"))),
            Pair("u", SwipeKeys(Key("ú"), down = Key("ü"))),
        )
    ),
    Layout(
        name = "Taiwanese Hokkien (POJ)",
        layout = """
            ´ ` ^ ¯ ˈ o͘ ⁿ ng -
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        otherLayers = listOf("""
            ´ ` ^ ¯ ˈ ó͘ ⁿ ńg -
            q w é r t y ú í ó p
            á s d f g h j k l
            z x c v b ń ḿ
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ ò͘ ⁿ ǹg -
            q w è r t y ù ì ò p
            à s d f g h j k l
            z x c v b ǹ m̀
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ ô͘ ⁿ n̂g -
            q w ê r t y û î ô p
            â s d f g h j k l
            z x c v b n̂ m̂
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ ō͘ ⁿ n̄g -
            q w ē r t y ū ī ō p
            ā s d f g h j k l
            z x c v b n̄ m̄
        """.trimIndent(), """
            ´ ` ^ ¯ ˈ o̍͘ ⁿ n̍g -
            q w e̍ r t y u̍ i̍ o̍ p
            a̍ s d f g h j k l
            z x c v b n̍ m̍
        """.trimIndent()),
        moveLayerKeys = "´ ` ^ ¯ ˈ".split(' ')
    ),
    Layout(
        name = "Tamil (InScript-like)",
        layout = """
            ◌ௌ ◌ை ◌ா ◌ீ ◌ூ ம ள ங ந ஞ ண
            ◌ோ ◌ே ◌் ◌ி ◌ு ப ர க த ச ட
            ◌ொ ◌ெ ழ ற ன வ ல ஸ ய
        """.trimIndent(),
        capsLayer = """
            ஔ ஐ ஆ ஈ ஊ ம ஹ ங ந ஜ ண
            ஓ ஏ அ இ உ ப ர ஃ த ச க்ஷ
            ஒ எ ழ ற ன வ ல ஷ ஶ
        """.trimIndent()
    ),
    Layout(
        name = "Tamil (Phonetic)",
        layout = """
            ஹ் ஷ் ஏ ற் ஶ் ஐ ஊ ஈ ஓ ஃ
            ஆ ஔ எ ர் த் ய் உ இ ஒ ப்
            அ ச் ட் ள் ங் ஞ் ஜ் க் ல்
            ழ் ண் ஸ் வ் ன் ந் ம்
        """.trimIndent(),
        capsLayer = """
            ௧ ௨ ௩ ௪ ௫ ௬ ௭ ௮ ௯ ௦
            ஆ ஔ எ ௹ த் ய் உ இ ஒ ப்
            அ ச் ட் ள் ங் ஞ் ஜ் க்ஷ் ல்
            ழ் ண் ஸ்ரீ வ் ன் ந் ம்
        """.trimIndent(),
        combiner = TamilCombiner
    ),
    Layout(
        name = "Thai (Big)",
        layout = """
            ๅ / _ ภ ถ ◌ุ ◌ึ ค ต จ ข ช
            ๆ ไ ำ พ ะ ◌ั ◌ี ร น ย บ ล
            ฟ ห ก ด เ ◌้ ◌่ า ส ว ง ฃ
            ผ ป แ อ ◌ิ ◌ื ท ม ใ ฝ
        """.trimIndent(),
        capsLayer = """
            + ๑ ๒ ๓ ๔ ◌ู ฿ ๕ ๖ ๗ ๘ ๙
            ๐ " ฎ ฑ ธ ◌ํ ◌๊ ณ ฯ ญ ฐ ,
            ฤ ฆ ฏ โ ฌ ◌็ ◌๋ ษ ศ ซ . ฅ
            ( ) ฉ ฮ ◌ฺ ◌์ ? ฒ ฬ ฦ
        """.trimIndent()
    ),
    Layout(
        name = "Telugu (InScript)",
        layout = """
            ◌ౄ ◌ః ఞ
            ◌ౌ ◌ై ◌ా ◌ీ ◌ూ బ హ గ ద జ డ
            ◌ో ◌ే ◌్ ◌ి ◌ు ప ర క త చ ట
            ◌ొ ◌ె ◌ం మ న వ ల స య
        """.trimIndent(),
        capsLayer = """
            ౠ ◌ః ఞ
            ఔ ఐ ఆ ఈ ఊ భ ఙ ఘ ధ ఝ ఢ
            ఓ ఏ అ ఇ ఉ ఫ ఱ ఖ థ ఛ ఠ
            ఒ ఎ ◌ఁ ణ ◌ృ ఋ ళ శ ష
        """.trimIndent(),
        bottomRowKey = zwnjKey
    ),
    Layout(
        name = "Telugu (Phonetic)",
        layout = """
            శ్ ణ్ ఏ ళ్ ఔ ఐ ఊ ఈ ఓ ష్
            ఆ ట్ ఎ ర్ త్ య్ ఉ ఇ ఒ ప్
            అ స్ ద్ ఫ్ గ్ హ్ జ్ క్ ల్
            ం డ్ చ్ వ్ బ్ న్ మ్
        """.trimIndent(),
        capsLayer = """
            ₹ ణ్ ౡ ఴ్ " ? ౠ ! ఓ ౙ్
            ఽ ఠ్ ఌ ఱ్ థ్ ఞ్ ఋ ఇ ఒ ప్
            అ స్ ధ్ ఫ్ ఘ్ ఙ్ ఝ్ ఖ్ ల్
            ఁ ఢ్ ఛ్ ః భ్ ౝ ౘ్
        """.trimIndent(),
        bottomRowKey = zwnjKey,
        combiner = TeluguCombiner
    ),
    Layout(
        name = "Tibetan",
        layout = """
            ↓ འ ཆ ཚ ཐ ཞ ཤ ཁ ཉ ཕ
            ཨ ཝ ◌ེ ར ཏ ཡ ◌ུ ◌ི ◌ོ པ
            ¦ ས ད ང ག ཧ ཇ ཀ ལ
            ཟ ཛ ཅ ཙ བ ན མ
        """.trimIndent(),
        capsLayer = """
            ↓ ཊ ཾ ཷ ཹ ྃ ཥ ྀ ཿ ྆
            ཱ ༜ ཻ ྲྀ ླྀ ཡ ཱུ ཱི ཽ ༔
            ༺ ༄༅།། ཌྷ ༼ གྷ ༽ ༑ ཀྵ ༻
            ཌ ཛྷ ༈ ༐ བྷ ཎ ༑
        """.trimIndent(),
        bottomRowKey = Key(text = " ", label = "␣", width = KeyWidth.FractionWidth(.1F)),
        space = "་",
        period = "།",
        combiner = TibetanCombiner
    ),
    Layout(
        name = "Turkish",
        layout = """
            ç ğ ş ü ı ö
            q w e r t y u i o p
            a s d f g h j k l
            z x c v b n m
        """.trimIndent(),
        capsLayer = """
            Ç Ğ Ş Ü I Ö
            Q W E R T Y U İ O P
            A S D F G H J K L
            Z X C V B N M
        """.trimIndent()
    ),
    Layout(
        name = "Udege (Khabarovsk)",
        layout = """
            ё ʻ ¯ ^ ғ ӡ њ ӈ ъ
            й ц у к е н г ш щ з х
            ф ы в а п р о л д ж э
            я ч с м и т ь б ю
        """.trimIndent(),
        otherLayers = listOf("""
            ё ʻ ¯ ^ ғ ӡ њ ӈ ъ
            й ц ӯ к е н г ш щ з х
            ф ы в а̄ п р о̄ л д ж э̄
            я ч с м ӣ т ь б ю
        """.trimIndent(), """
            ё ʻ ¯ ^ ғ ӡ њ ӈ ъ
            й ц у̂ к е н г ш щ з х
            ф ы в а̂ п р о̂ л д ж э̂
            я ч с м и̂ т ь б ю
        """.trimIndent()),
        moveLayerKeys = listOf("¯", "^"),
        decoupleRows = listOf(0)
    ),
    Layout(
        name = "Ukrainian (Small)",
        layout = """
            й ц у к е н г ш щ з х
            ф і в а п р о л д ж є
            я ч с м и т ь б ю
        """.trimIndent(),
        bottomRowKey = Key("ї", width = KeyWidth.FractionWidth(.1F)),
        swipeList = listOf(
            Pair("г", SwipeKeys(Key("ґ"), down = Key("₴")))
        )
    ),
    Layout(
        name = "Urdu",
        layout = """
            ض ص غ ڑ ٹ ث ح ئ ظ ط
            ق و ع ر ت ے ء ی ہ پ ذ
            آ ا س ڈ د ف گ ھ ج ک ل
            ز ش خ چ ط ب ں ن م
        """.trimIndent(),
        capsLayer = """
            ١ ٢ ٣ ٤ ٥ ٦ ٧ ٨ ٩ ٠
            ◌ْ ؤ ◌ٰ ڑ ٹ ◌َ ئ ◌ِ ۃ ◌ُ ,
            إ أ ص ڈ ؟ ◌ّ غ ح ض خ ◌ٔ
            ذ ژ ـ ث ظ . ؛ ۓ ◌٘
        """.trimIndent(),
        comma = "،",
        period = "۔",
        rightToLeft = true
    ),
    Layout(
        name = "Uyghur (Arabic)",
        layout = """
            ج ف ئ ژ گ خ ۆ لا ؟
            چ ۋ ې ر ت ي ۇ ڭ و پ
            ھ س د ا ە ى ق ك ل
            ز ش غ ۈ ب ن م
        """.trimIndent(),
        capsLayer = """
            ج ف ئ ژ گ خ ۆ لا ؟
            چ ۋ ې ر ت ي ۇ ڭ و پ
            ھ س ژ ف گ خ ج ۆ لا
            ز ش غ ۈ ب ن م
        """.trimIndent(),
        rightToLeft = true
    ),
    Layout(
        name = "Vietnamese",
        layout = """
            â ´ ê ◌̉ ` ~ ư ơ ô .
            q w e r t y u i o p
            a s d f g h j k l đ
            z x c v b n m ă
        """.trimIndent(),
        otherLayers = listOf("""
            ấ ´ ế ◌̉ ` ~ ứ ớ ố .
            q w é r t ý ú í ó p
            á s d f g h j k l đ
            z x c v b n m ắ
        """.trimIndent(), """
            ẩ ´ ể ◌̉ ` ~ ử ở ổ .
            q w ẻ r t ỷ ủ ỉ ỏ p
            ả s d f g h j k l đ
            z x c v b n m ẳ
        """.trimIndent(), """
            ầ ´ ề ◌̉ ` ~ ừ ờ ồ .
            q w è r t ỳ ù ì ò p
            à s d f g h j k l đ
            z x c v b n m ằ
        """.trimIndent(), """
            ẫ ´ ễ ◌̉ ` ~ ữ ỡ ỗ .
            q w ẽ r t ỹ ũ ĩ õ p
            ã s d f g h j k l đ
            z x c v b n m ẵ
        """.trimIndent(), """
            ậ ´ ệ ◌̉ ` ~ ự ợ ộ .
            q w ẹ r t ỵ ụ ị ọ p
            ạ s d f g h j k l đ
            z x c v b n m ặ
        """.trimIndent()),
        moveLayerKeys = "´ ◌̉ ` ~ .".split(' ')
    ),
    Layout(
        name = "Yiddish",
        layout = """
            יִ שׂ בֿ אַ אָ תּ וּ ײַ כּ פֿ
            ' פּ ק ר א ט ו ן ם פ
            ש ד ג כ ע י ח ל ך ף
            ז ס ב ה נ מ צ ת ץ
        """.trimIndent(),
        hasShift = false,
        rightToLeft = true,
        swipeList = listOf(
            Pair("'", SwipeKeys(Key("׳"), Key("״"))),
            Pair("ו", SwipeKeys(Key("וֹ"))),
            Pair("ב", SwipeKeys(Key("בּ"))),
            Pair("ג", SwipeKeys(Key("גּ"))),
            Pair("ד", SwipeKeys(Key("דּ"))),
            Pair("כ", SwipeKeys(Key("כֿ"))),
            Pair("ך", SwipeKeys(Key("ךּ"))),
            Pair("ף", SwipeKeys(Key("ףּ"))),
            Pair("פּ", SwipeKeys(Key("-")))
        )
    ),
)

val inBuiltLayouts = listOf(Layout(
    name = "English (QWERTY)",
    layout = """
        q w e r t y u i o p
        a s d f g h j k l
        z x c v b n m
    """.trimIndent()
).compile()) +
        (inBuiltSimpleLayoutsString.split("\n\n").map {
            val splitLayoutString = it.split("\n", limit = 2)
            Layout(
                name = splitLayoutString[0],
                layout = splitLayoutString[1],
                decoupleRows = if (splitLayoutString[1][0] == 'ё' || splitLayoutString[1][0] == 'е' || splitLayoutString[1][0] == 'ґ'
                    || splitLayoutString[1].split('\n')[0].split(' ').size <= 6) listOf(0) else emptyList()
            )
        } + layouts).map { //Log.d("MyTag", it.name)
            it.compile() }.sortedBy { it.name }
