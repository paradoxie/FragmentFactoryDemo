# FragmentFactoryDemo



	工厂模式是我们最常用的实例化对象模式了，
	是用工厂方法代替new操作的一种模式。

						------百毒百科

<!-- more -->

new操作是实例化对象，工厂实例化对象意味着大批量，当然这里的大批量指的是好几个，一些功能类似的类，将其进行抽象，使用公共父类或借口或抽象类来提取共有特性。工厂模式分了简单工厂和抽象工厂，我们在不知不觉中会用到的也是经常用到是简单工厂：通过参数来创建不同的对象。

本文内容十分简单，是**工厂设计模式**、**Tab页面**以及**MD控件TabLayout**结合的实现说明，即demo的说明。

## 上代码！ [FragmentFactoryDemo](https://github.com/paradoxie/FragmentFactoryDemo)

## 先上图

![我是图](http://odpd0x6u7.bkt.clouddn.com/F.gif)

上图中是app中经常会看到的一种主页效果，这里面设计到的四个东西：宿主activity，滑动的viewpager,填充内容的fragment,标题Tablayout。

由于填充fragment的内容各不相同，但是因为是相同级别的展现方式，很可能具有一些共性内容，比如都要获取数据，那抽个父类出来怎么样？

## 代码说明

### activity内的东西

````
    MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());//实例化自定义FragmentPagerAdapter
    mViewPager.setAdapter(myAdapter);//绑定ViewPager
    mTabLayout.setupWithViewPager(mViewPager);//ViewPager绑定TabLayout

````

在内部类**MyAdapter**中：

	getPageTitle()方法里面返回了tab的标题

	getItem()方法，将会使用工厂模式生产返回第position个fragment对象

	getCount()为fragment数量，即标题有多少个就应该有对应多少个fragment

### 工厂类FragmentFactory

先抽取了公共类BaseFragment，其余的Fragment只需继承公共类。然后在工厂类里面利用多态生产不同的Fragment，看代码：

````java
public class FragmentFactory {

    private static HashMap<Integer, BaseFragment> mFragmentHashMap = new HashMap<>();

    public static BaseFragment createFragment(int pos) {

        BaseFragment baseFragment = mFragmentHashMap.get(pos);//从集合中取出Fragment
        if (baseFragment == null) {//没有在集合中取到再进入实例化过程
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

````
注释清晰，这里new了四个Fragment对象，并使用HashMap作了性能优化，已经实例化的不会再次实例化。在**MyAdapter的getItem**方法中：

	BaseFragment fragment = FragmentFactory.createFragment(position);

调用后会使用FragmentFactory工厂生产出相应的fragment。


### 说明
> Demo中的BaseFragment只写了一个**TextView**，界面显示为相应fragment的类名。
>

## 上代码！ [FragmentFactoryDemo](https://github.com/paradoxie/FragmentFactoryDemo)


## 多说点儿

这次的内容相对比较简单，主要是针对这个代码设计模式的使用说明吧，Android里面使用最多的是观察这模式，典型的就是OnClickListener,还是平时写的接口回调什么的，呃，可以出个demo理解下这个流程，因为刚接触到接口回调的朋友们会很有用吧。

后面将会对MVP模式，Flux模式，MVVM模式这样的架构模式进行一些Demo说明。


---

> 本文作者：paradoxie

> 个人主页：[谢盒盒的小黑屋，不止说技术](http://www.paradoxie.cf/)

> 简书地址：[简书主页，专注技术类](http://www.jianshu.com/users/05f39939cbf3/latest_articles)

> github地址：[paradoxie](https://github.com/paradoxie)

> 转载请注明出处，蟹蟹!

> -------我的梦想真的是做一条咸鱼！
