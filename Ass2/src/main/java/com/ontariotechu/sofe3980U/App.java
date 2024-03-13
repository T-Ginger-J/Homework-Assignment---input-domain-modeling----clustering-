package com.ontariotechu.sofe3980U;

import java.io.File;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.AQBC;
import net.sf.javaml.clustering.DensityBasedSpatialClustering;
import net.sf.javaml.clustering.evaluation.AICScore;
import net.sf.javaml.clustering.evaluation.BICScore;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

public class App {
	public static void main(String[] args) throws Exception {

		Dataset data = FileHandler.loadDataset(new File("data/iris.data"), 4, ",");

		System.out.println("Cluster Method Kmeans");
		Clusterer cluster1 = new KMeans();

		long startTime = System.nanoTime();
		Dataset[] clusters = cluster1.cluster(data);
		long endTime = System.nanoTime();
		long length = endTime - startTime;
		System.out.println("run time is " + length);

		for(int i=0; i < clusters.length; i++) {
			System.out.println(clusters[i]);
		}

		ClusterEvaluation aic = new AICScore();
		ClusterEvaluation bic = new BICScore();
		ClusterEvaluation sse = new SumOfSquaredErrors();

		double aicScore = aic.score(clusters);
		double bicScore = bic.score(clusters);
		double sseScore = sse.score(clusters);

		System.out.println("AIC score: " + aicScore);
		System.out.println("BIC score: " + bicScore);
		System.out.println("Sum of squared errors: " + sseScore+"\n");

		System.out.println("Cluster Method Density Based Spatial Clustering");
		Clusterer cluster2 = new DensityBasedSpatialClustering();

		startTime = System.nanoTime();
		clusters = cluster2.cluster(data);
		endTime = System.nanoTime();
		length = endTime - startTime;
		System.out.println("run time is " + length);

		for(int i=0; i < clusters.length; i++) {
			System.out.println(clusters[i]);
		}

		aicScore = aic.score(clusters);
		bicScore = bic.score(clusters);
		sseScore = sse.score(clusters);

		System.out.println("AIC score: " + aicScore);
		System.out.println("BIC score: " + bicScore);
		System.out.println("Sum of squared errors: " + sseScore+"\n");

		System.out.println("Cluster Method AQBC");
		Clusterer cluster3 = new AQBC();

		startTime = System.nanoTime();
		clusters = cluster3.cluster(data);
		endTime = System.nanoTime();
		length = endTime - startTime;
		System.out.println("run time is " + length);

		for(int i=0; i < clusters.length; i++) {
			System.out.println(clusters[i]);
		}

		aicScore = aic.score(clusters);
		bicScore = bic.score(clusters);
		sseScore = sse.score(clusters);

		System.out.println("AIC score: " + aicScore);
		System.out.println("BIC score: " + bicScore);
		System.out.println("Sum of squared errors: " + sseScore+"\n");




	}

}
