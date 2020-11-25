package com.A.SehirTanitim

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mylayout.view.*

class MainActivity : AppCompatActivity() {
    var adapter : FoodAdapter? = null
    var cityList = ArrayList<Sehir>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityList.add(Sehir("Antalya", "Antalya, Türkiye'nin bir ili ve en kalabalık beşinci şehridir. 2019 sonu itibarıyla il nüfusu 2.511.700'dır. Türkiye'de \"turizmin başkenti\" olarak görülmektedir. Şehrin yüzölçümü 20.177 km2dir. İlde km2ye 115 kişi düşmektedir. En kalabalık ilçesi 2019 yılı itibarıyla 556.033 kişiyle Kepez ilçesidir. Nüfus yoğunluğunun en fazla olduğu ilçe ise km2 başına 5067 kişi ile Muratpaşa'dır. 19 ilçe ve belediye, bu belediyelerde toplam 910 mahalle bulunmaktadır. Tamamı Akdeniz Bölgesi'nin batısında yer alır ve Antalya Körfezi'yle Batı Torosların arasında kurulmuştur. Yüzölçümü bakımından Türkiye'nin beşinci büyük ilidir. Güneyinde Akdeniz, batısında Muğla, kuzeyinde Burdur ve Isparta, kuzeydoğusunda Konya, doğusunda ise Karaman ve Mersin illeri vardır. Antalya şehri, 1980 yılından sonra uygun iklim koşulları ve turizm etkinlikleri nedeniyle hızla gelişmiş ve buna paralel olarak il de günümüzde Türkiye'nin en kalabalık beşinci ili olmuştur. Antalya'da ekonomik hayat büyük oranda ticaret, tarım ve turizme dayalıdır. Antalya ilinin kapsadığı bölge tarih öncesinden günümüze dek pek çok medeniyeti barındırmıştır ve Türkiye'de en çok antik kent bulunan ildir. Sırasıyla Likyalılar, Lidyalılar, Pamfilyalılar, Bergamalılar, Romalılar, Bizanslılar, Selçuklular, Osmanlılar ve son olarak da Türkiye Cumhuriyeti hakimiyetinde bulunan Antalya bu medeniyetlerin hiçbirine başkentlik yapmamıştır.", R.drawable.antalya))
        cityList.add(Sehir("Bolu", "Türkiye yüzölçümünün %1,015'lik bölümünü kaplayan Bolu İli, 8,276 km² (827,600 ha) yüzölçümü ile Karadeniz Bölgesi’nin Batı Karadeniz bölümünde yer alır. İl arazisinin yaklaşık %18’ini tarım alanları oluşturmaktadır. Orman alanları ise %64’lük bir oran ile Türkiye ormanları içinde %2,55’lik paya sahiptir. Çayır ve meraların kapladığı alan yaklaşık %15’tir. Geriye kalan %8 dolayında alan ise tarım dışı alanlardır.\n" +
                "\n" +
                "Ortalama rakım 1000 m, merkez ilçe rakımı ise 725 m civarındadır. Matematiksel konum açısından 30 derece 32 dakika - 32 derece 36 dakika Doğu boylamları ile 40 derece 06 dakika - 41 derece 01 dakika Kuzey enlemleri arasındadır.\n" +
                "\n" +
                "Bolu İl Merkezine göre; Dörtdivan, Yeniçağa ve Gerede İlçeleri doğuda, Mengen kuzeydoğuda, Göynük ve Mudurnu İlçeleri güneybatıda, Seben ve Kıbrıscık İlçeleri ise güneyde yer almaktadır. Bolu’nun, batısında Düzce ve Sakarya, güneybatısında Bilecik ve Eskişehir, güneyinde Ankara, doğusunda Çankırı, kuzeyinde Zonguldak ve kuzey doğusunda Karabük İlleri yer alır.", R.drawable.bolu))
        cityList.add(Sehir("Çanakkale", "Çanakkale, Kuzeybatı Anadolu'da yer alan Çanakkale ilinin merkez ilçesidir. Nüfusu 2019 yılına göre 184.631 kişidir. Çanakkale'nin şu anki bulunduğu yerin adı 19. yüzyılda Kale-i Sultaniye olarak geçmektedir ve bu isim 1890 yılında şehrin resmî adı olarak kayıtlara geçmiştir. Çanakkale Osmanlı zamanında önemli bir kale işlevi görmüş olup, Kale-i Sultaniye (Osmanlı Türkçesi: قلعة سلطانيه ) ya da günümüz Türkçesi ile Sultaniye Kalesi ismi bu işlevin bir kanıtıdır. 17. yüzyılın sonlarından itibaren gelişen çömlek yapımı, şehrin bu konuda ün yapmasını sağlamıştır. Hatta yine bu zamanlarda bir seyyahın yapılan seramiğin kalitesinden etkilenip, bunu Hollanda'nın Delft şehrinde yapılan seramiklerle karşılaştırması şehre Çanak kalesi ismini vermiştir. Çanakkale isminin Yunanca'sı Δαρδανέλλια veya Dardanellia, ki bu isim de sonradan Dardanelles olarak İngilizceye çevrilmiştir. 1920'lerden itibaren İngilizler Çanakkale'ye Chanak veya Kale Sultanie demeye başladılar.", R.drawable.canakkale))
        cityList.add(Sehir("Denizli", "Denizli, Türkiye'nin bir ili ve en büyük on beşinci kent merkezidir. (Denizli merkez nüfusu 657.802 kişi) 2019 itibarıyla 1.037.208 kişilik il nüfusuna sahiptir. Tekstil ürünleri ve yöreye has Denizli horozu ile meşhurdur. Anadolu Yarımadası'nın güneybatı, Ege Bölgesi'nin güneydoğusunda yer almaktadır. Ege ve Akdeniz Bölgeleri arasında bir geçit durumundadır. Denizli ilinin her iki bölge üzerinde de toprakları vardır. Denizli ili 28° 38' - 30° 05' doğu meridyenleri (doğu uç noktası; Çivril ilçesi Gümüşsu - Gökgöl Köyü, Dinar sınırında Efekli Tepe, batı uç Aydın, Manisa; güneyde Muğla; kuzeyde Uşak illeri ile komşudur.) Yüzölçümü 12.134 km², denizden yüksekliği ise 219 m'dir. Bir sanayi, ihracat ve ticaret merkezi olan Denizli, aynı zamanda altmış beş bine yaklaşan üniversite öğrencisine ev sahipliği yapmaktadır. Bir yılda milyonlarca yerli ve yabancı turisti ağırlayan il, bir turizm kenti olmasının yanı sıra düzenlenen yerel, ulusal ve uluslararası etkinliklerle (bkz. festivaller) eğitim, kongre, kültür ve sanat merkezi özelliğindedir.", R.drawable.denizli))
        cityList.add(Sehir("İstanbul", "İstanbul (Türkçe telaffuz: [isˈtanbuɫ]), Türkiye'de yer alan şehir ve ülkenin 81 ilinden biri. Ülkenin en kalabalık, ekonomik, tarihi ve sosyo-kültürel açıdan önde gelen şehridir. Nüfus (2019 15.519.267.  Şehir, iktisadi büyüklük açısından dünyada 34., nüfus açısından belediye sınırları göz önüne alınarak yapılan sıralamaya göre Avrupa'da birinci, dünyada ise altıncı sırada yer almaktadır. İstanbul Türkiye'nin kuzeybatısında, Marmara kıyısı ve Boğaziçi boyunca, Haliç'i de çevreleyecek şekilde kurulmuştur. İstanbul kıtalararası bir şehir olup, Avrupa'daki bölümüne Avrupa Yakası veya Rumeli Yakası, Asya'daki bölümüne ise Anadolu Yakası veya Asya Yakası denir. Tarihte ilk olarak üç tarafı Marmara Denizi, Boğaziçi ve Haliç'in sardığı bir yarımada üzerinde kurulan İstanbul'un batıdaki sınırını İstanbul Surları oluşturmaktaydı. Gelişme ve büyüme sürecinde surların her seferinde daha batıya ilerletilerek inşa edilmesiyle 4 defa genişletilen şehrin 39 ilçesi vardır. Sınırları içerisinde ise büyükşehir belediyesi ile birlikte toplam 40 belediye bulunmaktadır.", R.drawable.istanbul))
        cityList.add(Sehir("Kayseri", "Kayseri, Türkiye'nin bir ili ve en kalabalık 15.şehridir. Nüfus (2019) 1,407,409. Ankara ve Konya'dan sonra İç Anadolu'nun üçüncü büyük kenti ve sanayi merkezidir. Akkışla, Bünyan, Develi, Hacılar, İncesu, Kocasinan, Melikgazi, Pınarbaşı, Sarıoğlan, Sarız, Tomarza, Yahyalı, Talas, Özvatan, Felahiye ve Yeşilhisar olmak üzere 16 ilçeden oluşmaktadır. Orta Kızılırmak Bölümünde, Erciyes Dağı'nın eteklerinde bir ildir. Kuzey ve kuzeybatıda Yozgat, kuzey ve kuzeydoğuda Sivas, doğuda Kahramanmaraş, güneyde Adana, güneybatıda Niğde, batıda ise Nevşehir illeriyle çevrilidir. Dünyanın en eski şehirlerinden biri olan Kayseri (eski Mazaka, Kaisareia), klasik çağlarda Kapadokya adı verilen bölgededir. Kızılırmak'ın güneyinde bulunan bu bölge, Tuz Gölü'nden Fırat nehrine kadar uzanır. İpek Yolu buradan geçer. Bölge, pek çok uygarlığın beşiği olmuştur.", R.drawable.kayseri))
        cityList.add(Sehir("Niğde", "Niğde İli'nin en eski adının Nahita ya da Nakita olduğu öne sürülmektedir.Nüfus (2018) 224,889. Bu ada ilk kez İbn Bibi'de rastlanmıştır. Eski CHP Niğde Milletvekili Dr. Avram Galanti ise Niğde kitabında:“Niğde’nin en eski ismi Anahita’dır. Anahita, bir ilahenin ismidir ki, kameri ve bereketi temsil eder.” demektedir. Nakida adı kimi zaman Nekide olarak da kullanılmış, 14. yüzyılda aynı sözcük Arap harfleriyle Nîkde okunacak biçimde yazılmıştır. Cumhuriyet'ten sonra bu ad, Niğde'ye dönüştürülmüştür. Yaklaşık 10.000 yıllık bir târihî geçmişe sahip olan Niğde’de yapılan arkeolojik araştırmalar, Paleolitik Çağ’a değin uzanan buluntular vermiştir.[5] Yazılı tarih döneminde ise Niğde’de sırasıyla: Asur Ticaret Kolonileri, Hititler, Tabal Geç Hitit Devleti, Frigyalılar, Persler, Makedonya Krallığı, Kapadokya Krallığı, Romalılar, Bizans İmparatorluğu, Anadolu Selçuklu Devleti, Eretna Beyliği, Karamanoğulları Beyliği ve Osmanlı Devleti hüküm sürmüştür. Niğde, Osmanlı hâkimiyetine 1470 yılında girmiştir.", R.drawable.nigde))
        cityList.add(Sehir("Trabzon", "Trabzon Türkiye'nin bir ili ve en kalabalık yirmi yedinci şehridir. Trabzon İl Nüfusu: 808.974'tur (2019 sonu). Karadeniz Bölgesi'nin Doğu Karadeniz Bölümü'nde yer alan ilin Karadeniz'e kıyısı bulunur. Karadeniz sahili ile Doğu Karadeniz Dağları arasında yer almakta olup yüzölçümü açısından az bir alan kaplar. Batısında Giresun'a bağlı Eynesil ilçesi, güneyinde Gümüşhane'ye bağlı Torul ilçesi ve Bayburt, doğusunda da Rize'ye bağlı İkizdere ve Kalkandere ilçeleri bulunur. 7 Eylül 2010 tarih ve 27695 sayılı resmi gazetede yayımlanan karar ile birlikte 7 belde ve 29 köy tüzel kişilikleri kaldırılarak belediye sınırlarına dahil edilmiştir. Bu son düzenleme ile birlikte belediye nüfusu 402.166'ya çıkmıştır. Trabzon, günümüzde Karadeniz Bölgesi'nin Samsun'dan sonra ikinci büyük kentidir. Trabzon, 12 Kasım 2012 tarihinde kabul edilen büyükşehir yasa tasarısı ile büyükşehir belediyesi olmuş ve merkez ilçe kaldırılarak Ortahisar ilçesi kurulmuştur. Trabzon iki il ile birlikte de \"şehzadeler şehri\" olarak anılır. Evliya Çelebi Trabzon için şöyle demiş: - Bu şehre küçük İstanbul denilse yeridir. İrem bağları gibi süslü bir şehirdir burası.", R.drawable.trabzon))
        cityList.add(Sehir("Urfa", "Şanlıurfa, eski ve halk arasındaki kısa adıyla Urfa, Türkiye'nin bir ili ve en kalabalık sekizinci şehri. 2019 Yılı verilerine göre nüfusu 2.073.614’dir. Doğuda Mardin, batıda Gaziantep, kuzeyde Adıyaman, kuzeydoğuda Diyarbakır illeri ve güneyde Suriye ile sınırı vardır. Şehrin eski isimleri Ur, Urhoy, Urhei, Orhei, Orhayi, Ruhai, Ruhha, Ar-Ruha, Reha ve Edessa'dır. Kurtuluş Savaşında gösterdiği başarının hatırasından dolayı 1984 yılında \"Şanlı\" unvanını almıştır. Şanlıurfa'nın 13 ilçesi vardır. Ortalama yükseltisi 518 metre olan Şanlıurfa, 19.451 km2'lik yüz ölçümü ile Türkiye'nin en büyük yedinci ilidir. 1919 yılında, önce İngilizlerin, daha sonra Fransızların işgaline uğrayan Urfa, 11 Nisan 1920'de Urfalı milisler tarafından işgalden kurtarılmış; Urfa milletvekili Osman Doğan ve 17 arkadaşının, Kurtuluş Savaşı'nda gösterdiği kahramanlıktan dolayı Urfa ilinin adının Şanlıurfa olarak değiştirilmesine ilişkin kanun teklifi TBMM tarafından 12 Haziran 1984 tarihinde kabul edilerek kanunlaşmıştır. 2016 yılında ise Şanlıurfa halkının Türk Kurtuluş Savaşı'nda gösterdiği kahramanlıktan dolayı TBMM tarafından bu kente İstiklal Madalyası verilmiştir.", R.drawable.urfa))
        cityList.add(Sehir("Yozgat", "Yozgat, Yozgat ilinin merkezidir. Yozgat İç Anadolu'nun merkezinde bulunan başkent Ankara'ya 217 kilometre uzaklıkta bulunan bir il. Yozgat'ın merkez ilçesinin 2018 yılı itibarıyla nüfusu 90.163'dür. Anadolu’nun en eski yerleşim merkezlerinden biri olduğu düşünülen yörede Alişar Höyüğü'nde yapılan kazılarda MÖ 3000 yıllarına ait eserler bulunmuştur. Hititlerin yerleşim merkezlerinden de biri olduğu bilinmektedir.MS 395’te Roma İmparatorluğu ikiye bölününce Anadolu, Doğu Roma yani Bizans’ın egemenliğine geçmiştir. Dönem dönem Sasani’ler bölgeye akınlar yapmış ancak hakimiyet sağlayamamışlardır. Timur’un Anadolu’dan ayrılması ile bölge sıkıntı çekmeye başlamış 1408 yılında Çelebi Mehmet tarafından Osmanlı Devleti'ne bağlanmıştır. Yavuz Sultan Selim döneminde Yozgat ve çevresinde Celal isimindeki bir Türkmen tarafından çıkarılan ve Celali İsyanları olarak bilinen isyan kontrol altına alınmıştır. 1526 yılında Kanuni Sultan Süleyman döneminde yörede bazı nüfus değişimleri yapılmış, Halep Türkmenlerinden Bozulus aşiretine bağlı Mamalu Türkmen oymakları yöreye yerleştirilmiştir.", R.drawable.yozgat))
        adapter = FoodAdapter(this, cityList)
        gridview.adapter = adapter
    }

    class FoodAdapter : BaseAdapter{
        var cityList = ArrayList<Sehir>()
        var context : Context? = null

        constructor(context: Context?, sehirList: ArrayList<Sehir>) : super() {
            this.cityList = sehirList
            this.context = context
        }

        override fun getCount(): Int {
            return cityList.size
        }

        override fun getItem(p0: Int): Any {
            return p0
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var city = this.cityList[p0]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var Sehirview = inflater.inflate(R.layout.mylayout, null)
            Sehirview.imageView.setImageResource(city.image!!)
            Sehirview.textView.text = city.name!!

            Sehirview.imageView.setOnClickListener{
                var intent = Intent(context, SehirDetay::class.java)
                intent.putExtra("name", city.name!!)
                intent.putExtra("description", city.description!!)
                intent.putExtra("image", city.image!!)
                context!!.startActivity(intent)
            }
            return Sehirview
        }
    }
}

