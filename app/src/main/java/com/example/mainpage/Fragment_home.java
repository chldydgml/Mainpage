package com.example.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_home extends Fragment {
    private ArrayList<Policy> mPolicyList;
    private MainAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private String mGender;
    private Bundle mBundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        setRecyclerView();

        mAdapter.setOnItemClickListener(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Policy item = mAdapter.getItem(pos);
                Intent intent = new Intent(v.getContext(), PopupActivity.class);
                intent.putExtra("title", item.getP_title());
                intent.putExtra("time", item.getTimeline());
                intent.putExtra("image", item.getImage());
                startActivity(intent);
            }
        });

        return root;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.main_rv);
        mPolicyList = new ArrayList<>();
        if (getArguments() != null) {
            mGender = getArguments().getString("gender");
        }
    }

    private void setRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mPolicyList.add(new Policy(R.drawable.p1, "청년 월세 지원정책", " 09.28 ~ 10.05", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.p2, "국민내일배움카드", " 10.01 ~ 12.05", "0 ~ 75세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.p3, "국민취업지원제도", "11.01 ~ 12.31", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p1, "청년취업연계", "01.01 ~ 12.31", "21 ~ 34세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p2, "드림포인트", "01.01 ~ 12.31", "21 ~ 34세", "남성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p3, "근로환경개선 지원", "01.01 ~ 12.31", "21 ~ 34세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p4, "청년 일자리 지원", "03.01 ~ 04.01", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p5, "도약기업 일자리 지원", "04.01 ~ 05.01", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p6, "면접청년 드림나래", "05.01 ~ 06.01", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p7, "일자리센터 운영지원", "03.01 ~ 06.01", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p8, "드림체크카드", "09.25 ~ 12.30", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p9, "드림FOR 청년통장", "03.05 ~ 11.05", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p10, "재직청년 월세지원", "05.21 ~ 09.29", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p11, "청년희망키움통장", "02.01 ~ 12.31", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p12, "학자금 대출이자지원", "08.01 ~ 11.20", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p13, "주택 매입임대 사업", "01.20 ~ 08.30", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p14, "일자리 이차보전", "09.18 ~ 11.18", "20 ~ 39세", "남성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p15, "부업대학생 운영", "01.30 ~ 12.30", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p16, "창업마을 드림촌", "11.31 ~ 12.31", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p17, "국제기구 청년인턴십", "05.15 ~ 09.15", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p18, "창업동아리 운영", "08.21 ~ 12.11", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p19, "마이스 청년인턴십", "04.01 ~ 12.01", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p20, "청년농정착 지원", "04.01 ~ 12.01", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p21, "청년 영농 스타트업", "03.20 ~ 09.20", "20 ~ 39세", "공통", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p22, "의료코디네이터 양성", "03.10 ~ 12.10", "20 ~ 39세", "여성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p23, "임신출산 건강관리", "01.01 ~ 12.31", "20 ~ 39세", "여성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p24, "출산 축하 지원", "02.01 ~ 12.31", "20 ~ 39세", "여성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p25, "산모신생아 건강관리", "03.01 ~ 12.31", "20 ~ 39세", "여성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p26, "군복무 자기개발지원", "06.20 ~ 12.20", "20 ~ 39세", "남성", "인천"));
        mPolicyList.add(new Policy(R.drawable.api_p27, "군복무 진로취업지원", "01.20 ~ 09.20", "20 ~ 39세", "남성", "인천"));

        mAdapter = new MainAdapter(mPolicyList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void updateFragment() {
        assert getFragmentManager() != null;
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}