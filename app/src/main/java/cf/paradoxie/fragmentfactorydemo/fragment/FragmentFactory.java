package cf.paradoxie.fragmentfactorydemo.fragment;/**
 * Created by xiehehe on 2016/10/21.
 */

import java.util.HashMap;

/**
 * User: xiehehe
 * Date: 2016-10-21
 * Time: 21:38
 * FIXME 工厂模式
 */
public class FragmentFactory {

    private static HashMap<Integer, BaseFragment> mFragmentHashMap = new HashMap<>();

    public static BaseFragment createFragment(int pos) {

        BaseFragment baseFragment = mFragmentHashMap.get(pos);//从集合中取出Fragment
        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    baseFragment = new FirstFragment();
                    break;
                case 1:
                    baseFragment = new SecondFragment();
                    break;
                case 2:
                    baseFragment = new ThirdFragment();
                    break;
                case 3:
                    baseFragment = new ForthFragment();
                    break;
                default:
                    break;
            }
            mFragmentHashMap.put(pos, baseFragment);//存入集合中
        }
        return baseFragment;
    }
}
