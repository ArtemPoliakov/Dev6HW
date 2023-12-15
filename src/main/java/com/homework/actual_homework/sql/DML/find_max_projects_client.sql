  WITH project_counts AS (
      SELECT client_id, count(project.id) as count_of_projects
         FROM project
         GROUP BY client_id
    )

  SELECT client.name, project_counts.count_of_projects
  FROM project_counts JOIN client
  ON client.id = client_id
  WHERE count_of_projects = (SELECT max(count_of_projects) FROM project_counts);