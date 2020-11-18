package com.cutthebutter.sopthw1
//
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


//@RecyclerViewAdapter는 context 객체가 필요
//@private val context : Context >> context 객체를 선언과 동시에 초기화 함
//RecyclerView.Adapter()를 상속받음, <>안에 Adapter가 어떤 ViewHolder에 전달할지 작성
class ProfileAdapter(private val context : Context) : RecyclerView.Adapter<ProfileViewHolder>(){

    //Adapter에 데이터를 가지고 있음
    var data = mutableListOf<ProfileData>()


    //Adapter에 3가지 메소드를 반드시 오버라이드 해줘야 함
    //1. onCreateViewHolder() : 각 Item 마다 layout을 inflate시키고 ViewHolder을 생성한다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
    return ProfileViewHolder(view)
    }

    //2. getItemCount : RecyclerView로 보여줄 데이터의 전체 길이를 리턴한다
    override fun getItemCount(): Int = data.size

    //3. onBindViewHolder() : ViewHolder에 데이터 전달 /View가 호출하여 실행되는 메소드
    // 각각의 아이템의 데이터를 바인딩시켜줌 뷰 홀더를 전달하고 어댑터는 position의 데이터를 결합함
    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        // 방금 만든 ViewHolder에 onBind()함수 호출
        holder.onBind(data[position])

        //onBindViewHolder에서 View에 setOnClickListner를 달고 만든 ItemClickListener를 호출
        holder.itemView.setOnClickListener{
            //itemview를 눌렀을 때 클릭이 되게 하고
            //인텐트를 넣어줌
            val intent = Intent(holder.itemView.context, DetailProfileActivity::class.java)
            //인텐트에서 데이터를 넣는 putExtra를 이용해 데이터를 저장해줌
            intent.putExtra("title",data[position].title)
            intent.putExtra("subtitle", data[position].subTitle)
            intent.putExtra("memo",data[position].memo)
            intent.putExtra("date",data[position].date)
            //아이템뷰에 해당하는 context에 intent를 적용해준다는 뜻
            startActivity(holder.itemView.context,intent,null)

        }
    }
    //꼭 클릭 리스너를 어댑터에서 선언해야 하나?
    //클릭리스너 인터페이스를 정의
    interface ItemClickListener{
        fun onClick(view: View, position: Int)
    }
    //클릭리스너 선언
    //lateinit : 늦은 초기화, var로만 선언 가능
    private lateinit var itemClickListener: ItemClickListener

    //클릭리스너 등록 메소드 : 액티비티에서 등록함
    fun setItemClickListner(itemClickListener: ItemClickListener){
        this.itemClickListener= itemClickListener
    }


}

