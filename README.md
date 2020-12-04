# SOPT27th

# SOPT27th

- 드디어 과제 1,2를 다함ㅜㅜ(2020.11.19)
- 3주차 과제도 다함ㅜㅜㅜ(2020.11.23)
- 6주차 과제 다함(2020.12.03)

## 👽시연 GIF
- 회원가입 페이지
 <img width="200" src="https://user-images.githubusercontent.com/42573282/99975076-1bacc400-2de5-11eb-950f-62ee3bd3e646.gif">
 
 - 리사이클러뷰
 <img width="200" src="https://user-images.githubusercontent.com/42573282/99974987-ff108c00-2de4-11eb-9215-9cbb54445f13.gif">
 
 
 - 바텀 내비게이션 바, 탭바
 <img width="200" src="https://user-images.githubusercontent.com/42573282/99974257-05eacf00-2de4-11eb-9281-e0b7a01ed3c2.gif">
 
 - 서버에 내가 등록 된 것 
 <img width="200" src="https://user-images.githubusercontent.com/42573282/100900989-bfddeb80-3506-11eb-9979-7e948f270ced.gif">
 
 - 회원 가입한 ID로 로그인
  <img width="200" src="https://user-images.githubusercontent.com/42573282/101188917-b33dcc80-3699-11eb-8858-a5a48eafefb0.png">
 
 - postman에서 가입 정보 확인 
  <img width="200" src="https://user-images.githubusercontent.com/42573282/101188920-b46ef980-3699-11eb-8a16-c9f877dc9c83.png">
 

 
 youtu.be/YpUQ5KQ72Fg

## 1주차 & 2주차


### 1주차 필수과제 : SignUpActivity 만들기
- 회원가입 화면인 SignUpActicity 만들기
- 로그인 화면에서 회원가입을 누르면 이동
> MainAcitvity.kt
```kotlin
val main_mainToSign = Intent(this, SignUpActivity::class.java)

 //버튼을 눌러 SignUpActivity로 이동
        signBtn.setOnClickListener {
            startActivityForResult(main_mainToSign,signUpToLoginRequest)
        }
```
- 회원가입 완료 클릭 이벤트 구현 + 
  - 모든 EditTextView에 데이터가 있을 경우 -> 회원가입 완료 ToastMessage
  - 하나라도 없을 경우 -> 빈칸이 있다는 ToastMessage
  >SignUpActivity.kt
  ```kotlin
        // 폼이 다 입력되었는지 확인 후 회원가입 처리
        signDoneBtn.setOnClickListener {
            if(itemEditName.text.toString() !=""
                    && itemEditId.text.toString() !=""
                    && itemEditPW.text.toString() !=""
                    && itemEditPwCheck.text.toString() !=""){
                Toast.makeText(this, itemEditName.text.toString() + "님, 가입을 환영합니다",
                        Toast.LENGTH_SHORT).show()
                
                sign_signToMain.putExtra("id",itemEditId.text.toString())
                sign_signToMain.putExtra("pw", itemEditPW.text.toString())

                //setResult(RESULT_OK,sign_signToMain)
                //finish()
            }else{
                Toast.makeText(this, "빈 칸이 있습니다. 모두 작성 바랍니다", Toast.LENGTH_SHORT).show()
            }
        }

```  
- 비밀번호 EdittextView는 입력 내용이 가려져 있어야 함
> activity_sign_up.xml

```
<EditText
        android:inputType="textPassword" />
        ```

- 모든 EditTextView는 미리보기가 있어야 함
> activity_sign_up.xml

```
<EditText
        android:hint="@string/pw"
        android:textColorHint="@color/hintGray"/>
```

### 1주차 성장과제 1 : 화면이동 
- 회원 가입에 성공한다면 이전 로그인 화면으로 돌아옴
> SignUpActivity.kt
```kotlin
   //mainActivity로 돌아가는 인텐트
        val sign_signToMain = Intent(this, MainActivity::class.java)
        
        signDoneBtn.setOnClickListener {
         ...
                setResult(RESULT_OK,sign_signToMain)
                finish()
                }     
 ```
- 이 때, 아이디와 비밀번호가 입력되어 있어야 함
> SignUpActivity
```kotlin
 signDoneBtn.setOnClickListener {
                sign_signToMain.putExtra("id",itemEditId.text.toString())
                sign_signToMain.putExtra("pw", itemEditPW.text.toString()) }
```
> MainActivity.kt
```kotlin
     if(idPwShared.getString("id","")!="" && idPwShared.getString("pw","")!=""){
            Toast.makeText(this, "자동로그인이 되었습니다.", Toast.LENGTH_SHORT).show()
            startActivity(main_mainToHome)
        }
```            

### 1주차 성장과제 2 : 자동로그인
- 로그인 버튼을 누르면 HomeActivity로 이동 
- 로그인에 성공하는 순간 id와 password를 기억해서 다음 로그인 때 자동으로 로그인 됨
- 자동로그인이 될 경우 자동로그인이 되었다는 메세지를 출력함
> MainActivity.kt
```kotlin
    //logiBtn을 누를 때 아이디와 PW의 데이터를 쉐어드 프리퍼런스에 저장함
        loginBtn.setOnClickListener {
            if(editLoginID.text.toString()!=""
                    && editLoginPW.text.toString()!=""){
                //@쉐프 안에 데이터를 저장할때 :
                //@쉐프에디터.put자료형("key이름",넣을 데이터
                idPwEditor.putString("id",editLoginID.text.toString())
                idPwEditor.putString("pw",editLoginPW.text.toString())
                //결과값을 t/f로 반환해야 한다면 commit을 사용하는데 그냥 apply를 사용하는게 나음
                idPwEditor.apply()
                Toast.makeText(this, "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                startActivity(main_mainToHome)
            }
            else{
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
```


### 2주차 필수 과제 : RecyclerView Listlayout
- 로그인 버튼을 누르면 RecyclerView를 보여주는 화면으로 이동
- 본인의 정보를 리사이클러뷰를 만들어줌

- 이미지는 고정된 이미지 사용
- 각 아이템을 클릭하면 해당 아이템의 정보를 가지고 있는 상세 화면으로 이동함
- 상세보기 화면에서 보여줘야 할 것 :Title, SubTitle, 작성날짜, 부가설명

### 2주차 성장과제 1 : Gridlayout
- 필수 과제로 만든 아이템을 격자형태로 바꾸기

### RecyclerView Item 이동 삭제 구현
- RecyclerView의 아이템의 이동 및 삭제를 구현
- 아이템을 길게 누르면 위치를 바꿀 수 있음
- 옆으로 슬라이드 하면 아이템이 삭제 됨

> ProfileData.kt
```kotlin
data class ProfileData(
        val title : String,
        val subTitle : String,
        val memo : String,
        val date : String

)
```

> ProfileActivity
```kotlin
        ProfileAdapter = ProfileAdapter(this)

        val profileRcv =findViewById<RecyclerView>(R.id.profileRcv)
        val changeSwitch = findViewById<Switch>(R.id.changeSwitch)

        ProfileAdapter.itemClick = object: ProfileAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {


                val item = ProfileAdapter.data[position]
                val intent = Intent(view.context, DetailActivity::class.java)

                intent.putExtra("title", item.title)
                intent.putExtra("subtitle",item.subTitle)
                intent.putExtra("memo", item.memo)
                intent.putExtra("date",item.date)
                setResult(1003, intent)
                startActivity(intent)
            }
        }

        val itemTouchHelperCallback = ItemTouchHelperCallback(ProfileAdapter)
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(profileRcv)

        ProfileAdapter.setItemViewType(0);
        profileRcv.adapter = ProfileAdapter
        profileRcv.layoutManager = LinearLayoutManager(this)

        changeSwitch.setOnCheckedChangeListener{CompoundButton, onSwitch ->
            //  스위치가 켜지면
            if (onSwitch){
                ProfileAdapter.setItemViewType(1)
                profileRcv.adapter = ProfileAdapter
                profileRcv.layoutManager = GridLayoutManager(this, 2)
            }
            //  스위치가 꺼지면
            else{
                ProfileAdapter.setItemViewType(0);
                profileRcv.adapter = ProfileAdapter
                profileRcv.layoutManager = LinearLayoutManager(this)
            }
        }

        ProfileAdapter.data = mutableListOf(
                ProfileData("이름", "이세민","전주 이씨 19대손이다", "2020.11.19" ),
                ProfileData("나이", "22", "만으로는 20살이다. 영원히 20살 하고 싶다", "2020.11.20"),
                ProfileData("파트", "안드로이드", "개발에 집중하고자 안드로이드로 들어왔다.","2020.11.21" ),
                ProfileData("좋아하는 색깔", "노란색", "노란 옷이 얼굴에 잘 받아 좋아한다", "2020.11.22"),
                ProfileData("좋아하는 음식", "마라탕", "마라탕...마라탕이 최고다", "2020.11.23"),
                ProfileData("Sopt", "27기", "이런 좋은 동아리 좀더 어릴 때 들어올걸 그랬다", "2020.11.24")
        )
        ProfileAdapter.notifyDataSetChanged()


    }
}
```
> DetailActivity
```kotlin
       detProfileTitle.text=intent.getStringExtra("title")
        detProfileSubtitle.text=intent.getStringExtra("subtitle")
        detProfileMemo.text=intent.getStringExtra("memo")
        detProfileDate.text=intent.getStringExtra("date")
        
 ```
> ProfileAdapter
```kotlin
   override fun onItemMoved(from: Int, to: Int) {
        if (from == to) {
            return
        }

        val fromItem = data.removeAt(from)
        data.add(to, fromItem)
        notifyItemMoved(from, to)
    }

    override fun onItemSwiped(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

}
```
### 3주차 과제
 > bottom_Fragment1
 ```kotlin
 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewpagerAdapter= TabPagerAdapter(childFragmentManager)

        val homeTabViewPager = view.findViewById<ViewPager>(R.id.homeTabViewPager)

        homeTabViewPager.adapter = viewpagerAdapter

        val homeTab = view.findViewById<TabLayout>(R.id.homeTab)

        homeTab.setupWithViewPager(homeTabViewPager)
        homeTab.apply{
            getTabAt(0)?.text = "Info"
            getTabAt(1)?.text ="Other"
        }

        super.onViewCreated(view, savedInstanceState)


    }
```
> bottom_Fragment2
```kotlin
 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        profileAdapter = ProfileAdapter(view.context) //this = RecyclerViewActivity

        val profileRcv = view?.findViewById<RecyclerView>(R.id.profileRcv)
        val changeSwitch = view?.findViewById<Switch>(R.id.changeSwitch)



        profileAdapter.itemClick = object : ProfileAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {

                val item = profileAdapter.data[position]
                val intent = Intent(view.context, DetailActivity::class.java)

                intent.putExtra("title", item.title)
                intent.putExtra("subtitle", item.subTitle)
                intent.putExtra("memo", item.memo)
                intent.putExtra("date", item.date)

                startActivity(intent)
            }
        }

        val itemTouchHelperCallback = ItemTouchHelperCallback(profileAdapter)
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(profileRcv)

        profileAdapter.setItemViewType(0);
        profileRcv.adapter = profileAdapter
        profileRcv.layoutManager = LinearLayoutManager(view.context)

        changeSwitch.setOnCheckedChangeListener { CompoundButton, onSwitch ->
            //  스위치가 켜지면
            if (onSwitch) {
                profileAdapter.setItemViewType(1)
                profileRcv.adapter = profileAdapter
                profileRcv.layoutManager = GridLayoutManager(view.context, 2)
            }
            //  스위치가 꺼지면
            else {
                profileAdapter.setItemViewType(0);
                profileRcv.adapter = profileAdapter
                profileRcv.layoutManager = LinearLayoutManager(view.context)
            }
        }

        profileAdapter.data = mutableListOf(
            ProfileData("이름", "이세민", "전주 이씨 19대손이다", "2020.11.19"),
            ProfileData("나이", "22", "만으로는 20살이다. 영원히 20살 하고 싶다", "2020.11.20"),
            ProfileData("파트", "안드로이드", "개발에 집중하고자 안드로이드로 들어왔다.", "2020.11.21"),
            ProfileData("좋아하는 색깔", "노란색", "노란 옷이 얼굴에 잘 받아 좋아한다", "2020.11.22"),
            ProfileData("좋아하는 음식", "마라탕", "마라탕...마라탕이 최고다", "2020.11.23"),
            ProfileData("Sopt", "27기", "이런 좋은 동아리 좀더 어릴 때 들어올걸 그랬다", "2020.11.24")
        )
        profileAdapter.notifyDataSetChanged()


    }
    ```
 > HomeActivity
 
    ```kotlin
     viewpagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments = listOf(
            fragment1,
            fragment2,
            fragment3
        )

        home_bottom_viewPager.adapter =viewpagerAdapter

        home_bottom_viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                home_bottom_navi.menu.getItem(position).isChecked=true
            }
        })

        home_bottom_navi.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when(it.itemId){
                R.id.menu_bottom_first -> index = 0
                R.id.menu_bottom_second -> index =1
                R.id.menu_bottom_third -> index =2

            }
            home_bottom_viewPager.currentItem = index
            true
        }
```
> TabPagerAdaper
```kotlin
class TabPagerAdapter (fm : FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getItem(position: Int): Fragment = when(position){
        0 -> tab_Fragment1()
        1 -> tab_Fragment2()
        else -> throw IllegalStateException("Unexpcted position $position")
    }
    override fun getCount(): Int = 2
}
 ```
 
 > PagerAdapter


## 6주차 과제

### Signup
> RequestSignupData
```
data class RequestSignupData(
    val email : String,
    val password : String,
    val userName : String

)
```
> ResponseSignupData

```
data class ResponseSignupData(
    val data: Data,
//    val message: String,
    // 아래 어노테이션을 통해 Json 객체의 값과 대응시킬 수 있다.

    val status: Int,
    val success:Boolean,
    @SerializedName("message")
    val responseMessage:String,
){
    data class Data(
        val email : String,
        val password : String,
        val userName : String
    )
}
```

> SoptServiceUp
```
    @Headers("Content-Type:application/json")
    @POST("users/signup")

    fun postSignup(
        @Body body : RequestSignupData
    ) : Call<ResponseSignupData>
}
```
> SoptServiceImp
```
 val signup : SoptServiceUp = retrofit.create(SoptServiceUp::class.java)//Interface 객체를 넘겨 실제 구현체 생성
}
```

> SignupActivity

```
val call : Call<ResponseSignupData> = SoptServiceImpl.signup.postSignup(
                RequestSignupData(email = email, password = password , userName = name)
            )

            call.enqueue(object : Callback<ResponseSignupData> {
                override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                    //통신 실패 로직
                }

                override fun onResponse(call: Call<ResponseSignupData>, response: Response<ResponseSignupData>) {
                    response.takeIf { it.isSuccessful }
                        ?.body()
                        ?.let{
                                it ->
                            //do somting
                        } ?: showError(response.errorBody())
                }
            })
        }
```






