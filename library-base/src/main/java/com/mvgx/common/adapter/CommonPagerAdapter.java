package com.mvgx.common.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author Arthur
 * @Date 2023/3/29 16:48
 */
public class CommonPagerAdapter  extends FragmentPagerAdapter {

    private List<Fragment> list;//ViewPager要填充的fragment列表
    private List<String> title;//tab中的title文字列表

    public CommonPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {//获得position中的fragment来填充
        return list.get(position);
    }

    @Override
    public int getCount() {//返回FragmentPager的个数
        return list.size();
    }

    //FragmentPager的标题,如果重写这个方法就显示不出tab的标题内容
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}

