package com.example.pc_.sendorder.view.view.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc_.sendorder.R;
import com.example.pc_.sendorder.view.view.activity.OrderDetailActivity;

import butterknife.BindView;

/**
 * Created by pc- on 2017/8/13.
 */
public class SelfFragment extends BaseFragment implements View.OnClickListener{


    @BindView(R.id.sender_judge_mark)
    TextView senderJudgeMark;
    @BindView(R.id.sender_judge_middle)
    Button senderJudgeMiddle;
    @BindView(R.id.sender_judge_middle_text)
    TextView senderJudgeMiddleText;
    @BindView(R.id.sender_judge_two_text)
    TextView senderJudgeTwoText;
    @BindView(R.id.sender_judge_one_text)
    TextView senderJudgeOneText;
    @BindView(R.id.sender_judge_four_text)
    TextView senderJudgeFourText;
    @BindView(R.id.sender_judge_five_text)
    TextView senderJudgeFiveText;
    @BindView(R.id.sender_judge_two)
    Button senderJudgeTwo;
    @BindView(R.id.sender_judge_one)
    Button senderJudgeOne;
    @BindView(R.id.sender_judge_four)
    Button senderJudgeFour;
    @BindView(R.id.sender_judge_five)
    Button senderJudgeFive;
    @BindView(R.id.sender_cut_line)
    TextView senderCutLine;
    @BindView(R.id.sender_today_image)
    ImageView senderTodayImage;
    @BindView(R.id.sender_today_text)
    TextView senderTodayText;
    @BindView(R.id.sender_today_count_text)
    TextView senderTodayCountText;
    @BindView(R.id.sender_cut_line1)
    TextView senderCutLine1;
    @BindView(R.id.sender_mouth_image)
    ImageView senderMouthImage;
    @BindView(R.id.sender_mouth_text)
    TextView senderMouthText;
    @BindView(R.id.sender_mouth_count_text)
    TextView senderMouthCountText;
    @BindView(R.id.sender_cut_line2)
    TextView senderCutLine2;
    @BindView(R.id.sender_detail_image)
    ImageView senderDetailImage;
    @BindView(R.id.sender_detail_text)
    TextView senderDetailText;
    @BindView(R.id.sender_cut_line3)
    TextView senderCutLine3;
    @BindView(R.id.sender_quit_image)
    ImageView senderQuitImage;
    @BindView(R.id.sender_quit_text)
    TextView senderQuitText;
    @BindView(R.id.sender_cut_line4)
    TextView senderCutLine4;
    @BindView(R.id.sender_ever_image)
    ImageView senderEverImage;
    @BindView(R.id.sender_ever_text)
    TextView senderEverText;
    @BindView(R.id.sender_cut_line5)
    TextView senderCutLine5;


    public MyDialogFragment myDialogFragment;

    @Override
    public void rxPreLoad() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.self_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {


    }

    @Override
    public void initEvent() {

        senderDetailText.setOnClickListener(this);
        senderQuitText.setOnClickListener(this);
        senderEverText.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sender_detail_text:
                Intent intent=new Intent(getActivity(), OrderDetailActivity.class);
                startActivity(intent);
                break;
            case R.id.sender_quit_text:
                quitOrEver(1);
                break;
            case R.id.sender_ever_text:
                quitOrEver(2);
                break;
        }

    }

    public void  quitOrEver(final int j){
        //能进入该方法，说明j位置由数据
        Bundle bundle = new Bundle();
        if(j==1){
            bundle.putString("dialogContent", "是否确定退出");
        }else  if(j==2){
            bundle.putString("dialogContent", "是否确定解除派送员职务");
        }
        myDialogFragment = MyDialogFragment.newInstance(bundle);
        myDialogFragment.show(getActivity().getFragmentManager(),"dialogFragment");

        myDialogFragment.setDialogListener(new MyDialogFragment.IDialogListener() {
            @Override
            public void confirm() {

                if(j==2){
                    SharedPreferences sharedPreferences=getActivity().getSharedPreferences("Login",0);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("HasLogin",false);
                    editor.apply();
                }else{
                    //发送信息告诉服务器，将该 商户的信息删除
                }
                myDialogFragment.dismiss();
                getActivity().finish();
            }
            @Override
            public void cancel() {

                myDialogFragment.dismiss();

            }
        });
    }
}
