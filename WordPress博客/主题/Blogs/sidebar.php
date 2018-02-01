<div id="sidebar" class="widget-area">		
		<?php wp_reset_query();if (is_single() || is_page() ) {?>
				<?php dynamic_sidebar( 'sidebar-2' ); ?>
			<?php }else { ?>
				<?php dynamic_sidebar( 'sidebar-1' ); ?>
			<?php } ?>
</div>
<!--百度联盟广告 
<?php if ( is_home()==false){ ?>	 
 <div><b>本站没有盈利,广告敬请谅解,站主只希望能回一点服务器费用</b></div>
<div><b>若文章对您有帮助,方便的可以点击一下广告,土豪可以进行打赏一波喔,非常感谢</b></div>
<script type="text/javascript">
    /*创建于 2017/12/25*/
    var cpro_id = "u3171792";
</script>
<script type="text/javascript" src="http://cpro.baidustatic.com/cpro/ui/c.js"></script> -->
	<?php } ?>
-->
</div>