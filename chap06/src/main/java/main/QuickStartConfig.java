package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import board.ArticleCacheAspect;
import board.ArticleDao;
import board.MemberServiceImpl;
import board.MemoryArticleDao;
import board.ProfilingAspect;
import board.ReadArticleServiceImpl;
import board.UpdateMemberInfoTraceAspect;
import board.WriteArticleServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class QuickStartConfig {

	@Bean
	public ProfilingAspect performanceTraceAspect() {
		return new ProfilingAspect();
	}

	@Bean
	public UpdateMemberInfoTraceAspect memberInfoTraceAspect() {
		return new UpdateMemberInfoTraceAspect();
	}

	@Bean
	public ArticleDao articleDao() {
		return new MemoryArticleDao();
	}

	@Bean
	public WriteArticleServiceImpl writeAriticleService() {
		return new WriteArticleServiceImpl(articleDao());
	}

	@Bean
	public MemberServiceImpl memberSerive() {
		return new MemberServiceImpl();
	}

	@Bean
	public ArticleCacheAspect cache() {
		return new ArticleCacheAspect();
	}

	@Bean
	public ReadArticleServiceImpl readArticleService() {
		ReadArticleServiceImpl svc = new ReadArticleServiceImpl();
		svc.setArticleDao(articleDao());
		return svc;
	}
}
