WITH project_duration AS (
    SELECT id,
    (SELECT YEAR(project.finish_date)*12 + MONTH(project.finish_date)-
            YEAR(project.start_date)*12 + MONTH(project.start_date))
            as duration
    FROM project
)

SELECT * FROM project_duration
WHERE duration = (SELECT max(duration) FROM project_duration);