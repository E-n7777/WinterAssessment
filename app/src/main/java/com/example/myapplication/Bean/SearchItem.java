package com.example.myapplication.Bean;

import java.util.List;
/**
 * description ：搜索item
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SearchItem {

    /**
     * data : {"curPage":1,"datas":[{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":27997,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3625","niceDate":"15小时前","niceShareDate":"15小时前","origin":"","prefix":"","projectLink":"","publishTime":1708185600000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1708186200000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-02-11 ~ 2024-02-18）","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27993,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3623","niceDate":"2024-02-11 00:00","niceShareDate":"2024-02-11 00:10","origin":"","prefix":"","projectLink":"","publishTime":1707580800000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1707581400000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-02-04 ~ 2024-02-11）","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27992,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/9dJsDAiTcWODgE4G0VcwBg","niceDate":"2024-02-07 00:00","niceShareDate":"2024-02-08 10:07","origin":"","prefix":"","projectLink":"","publishTime":1707235200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1707358050000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android AMS 剖析 &mdash;&mdash; Activity 管理之任务与返回栈","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27985,"isAdminAdd":false,"link":"https://juejin.cn/post/7329807974968148002","niceDate":"2024-02-06 23:36","niceShareDate":"2024-02-06 23:36","origin":"","prefix":"","projectLink":"","publishTime":1707233765000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1707233765000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"HarmonyOS一杯冰美式的时间 -- 验证码框","type":0,"userId":2,"visible":0,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27975,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3621","niceDate":"2024-02-04 00:00","niceShareDate":"2024-02-04 00:10","origin":"","prefix":"","projectLink":"","publishTime":1706976000000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1706976600000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-01-28 ~ 2024-02-04）","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27988,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/mB03oUzhl2VnG2lhCrXW4Q","niceDate":"2024-02-02 00:00","niceShareDate":"2024-02-07 09:24","origin":"","prefix":"","projectLink":"","publishTime":1706803200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1707269065000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"App的好坏，卡顿占一半？Android线上卡顿监控","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27987,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/8iIFXzqd1GtJ_OeuVEtXjA","niceDate":"2024-02-01 00:00","niceShareDate":"2024-02-07 09:24","origin":"","prefix":"","projectLink":"","publishTime":1706716800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1707269048000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"你真的了解ViewModel的设计思想吗？","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27971,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/Bq2AJMdIzlZNppCoRfQzJQ","niceDate":"2024-01-31 00:00","niceShareDate":"2024-02-01 09:21","origin":"","prefix":"","projectLink":"","publishTime":1706630400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1706750510000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"鸿蒙：5 分钟秒懂 ArkTs，不能错过的知识点解析","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27968,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/Fg-BiU0hE4HTYG8A2VA2kA","niceDate":"2024-01-30 00:00","niceShareDate":"2024-01-31 09:17","origin":"","prefix":"","projectLink":"","publishTime":1706544000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1706663870000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"大公司如何做 APP：背后的开发流程和技术","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27941,"isAdminAdd":false,"link":"https://juejin.cn/post/7328602385470947363","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:42","origin":"","prefix":"","projectLink":"","publishTime":1706449533000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449333000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 布局加载优化该何去何从","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27942,"isAdminAdd":false,"link":"https://juejin.cn/post/7328394754256683049","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:42","origin":"","prefix":"","projectLink":"","publishTime":1706449531000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449350000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"图解 EventThread","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27943,"isAdminAdd":false,"link":"https://juejin.cn/post/7327725045425946662","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:42","origin":"","prefix":"","projectLink":"","publishTime":1706449530000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449368000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Flutter鸿蒙终端一体化-混沌初开","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27944,"isAdminAdd":false,"link":"https://juejin.cn/post/7327686547808927778","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:43","origin":"","prefix":"","projectLink":"","publishTime":1706449528000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449396000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"聊聊鸿蒙HarmonyOS NEXT 的技术细节","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27945,"isAdminAdd":false,"link":"https://www.bilibili.com/video/BV18T4y1h7ch/?spm_id_from=333.999.0.0","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:43","origin":"","prefix":"","projectLink":"","publishTime":1706449526000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449429000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"【资深Android开发】不吹不黑聊鸿蒙_哔哩哔哩_bilibili","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27938,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3616","niceDate":"2024-01-28 00:00","niceShareDate":"2024-01-28 00:10","origin":"","prefix":"","projectLink":"","publishTime":1706371200000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1706371800000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-01-21 ~ 2024-01-28）","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":true,"pageCount":1,"size":20,"total":4}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":27997,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3625","niceDate":"15小时前","niceShareDate":"15小时前","origin":"","prefix":"","projectLink":"","publishTime":1708185600000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1708186200000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-02-11 ~ 2024-02-18）","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27993,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3623","niceDate":"2024-02-11 00:00","niceShareDate":"2024-02-11 00:10","origin":"","prefix":"","projectLink":"","publishTime":1707580800000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1707581400000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-02-04 ~ 2024-02-11）","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27992,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/9dJsDAiTcWODgE4G0VcwBg","niceDate":"2024-02-07 00:00","niceShareDate":"2024-02-08 10:07","origin":"","prefix":"","projectLink":"","publishTime":1707235200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1707358050000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"Android AMS 剖析 &mdash;&mdash; Activity 管理之任务与返回栈","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":494,"chapterName":"广场","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27985,"isAdminAdd":false,"link":"https://juejin.cn/post/7329807974968148002","niceDate":"2024-02-06 23:36","niceShareDate":"2024-02-06 23:36","origin":"","prefix":"","projectLink":"","publishTime":1707233765000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1707233765000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"HarmonyOS一杯冰美式的时间 -- 验证码框","type":0,"userId":2,"visible":0,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27975,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3621","niceDate":"2024-02-04 00:00","niceShareDate":"2024-02-04 00:10","origin":"","prefix":"","projectLink":"","publishTime":1706976000000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1706976600000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-01-28 ~ 2024-02-04）","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27988,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/mB03oUzhl2VnG2lhCrXW4Q","niceDate":"2024-02-02 00:00","niceShareDate":"2024-02-07 09:24","origin":"","prefix":"","projectLink":"","publishTime":1706803200000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1707269065000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"App的好坏，卡顿占一半？Android线上卡顿监控","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27987,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/8iIFXzqd1GtJ_OeuVEtXjA","niceDate":"2024-02-01 00:00","niceShareDate":"2024-02-07 09:24","origin":"","prefix":"","projectLink":"","publishTime":1706716800000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1707269048000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"你真的了解ViewModel的设计思想吗？","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27971,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/Bq2AJMdIzlZNppCoRfQzJQ","niceDate":"2024-01-31 00:00","niceShareDate":"2024-02-01 09:21","origin":"","prefix":"","projectLink":"","publishTime":1706630400000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1706750510000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"鸿蒙：5 分钟秒懂 ArkTs，不能错过的知识点解析","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27968,"isAdminAdd":false,"link":"https://mp.weixin.qq.com/s/Fg-BiU0hE4HTYG8A2VA2kA","niceDate":"2024-01-30 00:00","niceShareDate":"2024-01-31 09:17","origin":"","prefix":"","projectLink":"","publishTime":1706544000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1706663870000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"大公司如何做 APP：背后的开发流程和技术","type":0,"userId":-1,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27941,"isAdminAdd":false,"link":"https://juejin.cn/post/7328602385470947363","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:42","origin":"","prefix":"","projectLink":"","publishTime":1706449533000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449333000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 布局加载优化该何去何从","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27942,"isAdminAdd":false,"link":"https://juejin.cn/post/7328394754256683049","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:42","origin":"","prefix":"","projectLink":"","publishTime":1706449531000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449350000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"图解 EventThread","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27943,"isAdminAdd":false,"link":"https://juejin.cn/post/7327725045425946662","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:42","origin":"","prefix":"","projectLink":"","publishTime":1706449530000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449368000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Flutter鸿蒙终端一体化-混沌初开","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27944,"isAdminAdd":false,"link":"https://juejin.cn/post/7327686547808927778","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:43","origin":"","prefix":"","projectLink":"","publishTime":1706449528000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449396000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"聊聊鸿蒙HarmonyOS NEXT 的技术细节","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27945,"isAdminAdd":false,"link":"https://www.bilibili.com/video/BV18T4y1h7ch/?spm_id_from=333.999.0.0","niceDate":"2024-01-28 21:45","niceShareDate":"2024-01-28 21:43","origin":"","prefix":"","projectLink":"","publishTime":1706449526000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1706449429000,"shareUser":"鸿洋","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"【资深Android开发】不吹不黑聊鸿蒙_哔哩哔哩_bilibili","type":0,"userId":2,"visible":1,"zan":0},{"adminAdd":false,"apkLink":"","audit":1,"author":"张鸿洋","canEdit":false,"chapterId":543,"chapterName":"Android技术周报","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":27938,"isAdminAdd":false,"link":"https://www.wanandroid.com/blog/show/3616","niceDate":"2024-01-28 00:00","niceShareDate":"2024-01-28 00:10","origin":"","prefix":"","projectLink":"","publishTime":1706371200000,"realSuperChapterId":542,"selfVisible":0,"shareDate":1706371800000,"shareUser":"","superChapterId":543,"superChapterName":"技术周报","tags":[],"title":"Android 技术周刊 （2024-01-21 ~ 2024-01-28）","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : true
         * pageCount : 1
         * size : 20
         * total : 4
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * adminAdd : false
             * apkLink :
             * audit : 1
             * author : 张鸿洋
             * canEdit : false
             * chapterId : 543
             * chapterName : Android技术周报
             * collect : false
             * courseId : 13
             * desc :
             * descMd :
             * envelopePic :
             * fresh : true
             * host :
             * id : 27997
             * isAdminAdd : false
             * link : https://www.wanandroid.com/blog/show/3625
             * niceDate : 15小时前
             * niceShareDate : 15小时前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1708185600000
             * realSuperChapterId : 542
             * selfVisible : 0
             * shareDate : 1708186200000
             * shareUser :
             * superChapterId : 543
             * superChapterName : 技术周报
             * tags : []
             * title : Android 技术周刊 （2024-02-11 ~ 2024-02-18）
             * type : 0
             * userId : -1
             * visible : 1
             * zan : 0
             */

            private boolean adminAdd;
            private String apkLink;
            private int audit;
            private String author;
            private boolean canEdit;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String descMd;
            private String envelopePic;
            private boolean fresh;
            private String host;
            private int id;
            private boolean isAdminAdd;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int realSuperChapterId;
            private int selfVisible;
            private long shareDate;
            private String shareUser;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public boolean isAdminAdd() {
                return adminAdd;
            }

            public void setAdminAdd(boolean adminAdd) {
                this.adminAdd = adminAdd;
            }

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public boolean isCanEdit() {
                return canEdit;
            }

            public void setCanEdit(boolean canEdit) {
                this.canEdit = canEdit;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDescMd() {
                return descMd;
            }

            public void setDescMd(String descMd) {
                this.descMd = descMd;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIsAdminAdd() {
                return isAdminAdd;
            }

            public void setIsAdminAdd(boolean isAdminAdd) {
                this.isAdminAdd = isAdminAdd;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getRealSuperChapterId() {
                return realSuperChapterId;
            }

            public void setRealSuperChapterId(int realSuperChapterId) {
                this.realSuperChapterId = realSuperChapterId;
            }

            public int getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(int selfVisible) {
                this.selfVisible = selfVisible;
            }

            public long getShareDate() {
                return shareDate;
            }

            public void setShareDate(long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}
