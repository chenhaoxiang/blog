<div id="footer" alog-group="log-footer">
<div class="foot">
	<?php wp_reset_query();if ( is_home()){ ?>	
		<div id="links">
			<ul class="linkcat">
				<li><strong>友情链接：</strong></li>
				<?php
				wp_list_bookmarks('title_li=&categorize=0&orderby=rand&show_images=&limit=30&category='.get_option('ygj_link_id'));	
				?>
			</ul>
<div class="clear"></div>
</div>
	<?php } ?>
<div class="ps">
<div class="p p2">
<div class="p-content">
<p class="t2">站点相关</p>
<ul>
<?php echo stripslashes(get_option('ygj_yjcylj')); ?>
</ul>
</div>
<div class="clear"></div>
<div class="site-info">			
			Copyright ©&nbsp;
		<a href="http://chenhaoxiang.cn/" target="_blank"> 
			<?php bloginfo('name');?>
		</a>
		<span class="footer-tag">
				&nbsp; | &nbsp; Powered by WordPress &nbsp; | &nbsp;  
			<a href="http://www.miitbeian.gov.cn/" target="_blank" rel="nofollow">
				<?php echo stripslashes(get_option('ygj_icp')); ?>
			</a>
		</span>
<!-- 360网站安全验证-->
	<?php if ( is_home()){ ?>	
		<a href="http://webscan.360.cn/index/checkwebsite/url/chenhaoxiang.cn" target="_blank"><img border="0" style="height: 25px;" src="http://webscan.360.cn/status/pai/hash/f8cd0a6ff240bcc575aee0fbfd68243a"/></a>
	<?php } ?>
		

		</div>
</div>

<div class="p p3">
<div class="p-content">
<p class="t2">欢迎您关注我们</p>
<div class="qcode clearfix">
<div class="img-container">
<img src="<?php echo stripslashes(get_option('ygj_gzwm_ewm')); ?>" alt="<?php bloginfo('name'); ?>的公众号">
</div>
<div class="link-container">
<a href="<?php echo stripslashes(get_option('ygj_gzwm_lj1')); ?>" target="_blank">
<?php echo stripslashes(get_option('ygj_gzwm_bt1')); ?></a>
<a href="<?php echo stripslashes(get_option('ygj_gzwm_lj2')); ?>" target="_blank">
<?php echo stripslashes(get_option('ygj_gzwm_bt2')); ?></a>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<div class="tools">
    <a class="tools_top" title="返回顶部"></a>
    <?php wp_reset_query(); if ( is_single() || is_page() ) { ?>
        <a class="tools_comments" title="发表评论"></a>
    <?php } else {?>
        <a href="<?php echo stripslashes(get_option('ygj_lyburl')); ?>#respond" class="tools_comments" title="给我留言" target="_blank" rel="nofollow"></a>
    <?php } ?>
</div>

<!--百度自动推送-->
<script>
(function(){
    var bp = document.createElement('script');
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>

<?php if (!get_option('ygj_post_baidu') ) { ?>
<?php if (is_single() || is_page() ) { ?>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText": "【" + $("title").text() + "】" + "<?php echo wp_trim_words( get_the_content(), 108, '...' );?>","bdMini":"2","bdMiniList":false,"bdPic": $(".single-content img:first") ? $(".single-content img:first").attr("src") : "","bdStyle":"1","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
<?php }} ?>
<script type="text/javascript" src="<?php echo esc_url( get_template_directory_uri() ); ?>/js/superfish.js"></script>
<?php wp_footer(); ?>
</body></html>