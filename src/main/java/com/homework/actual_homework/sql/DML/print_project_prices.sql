SELECT project.id,
(
    SELECT sum(worker.salary)
    FROM worker
    WHERE worker.id IN (
                         SELECT project_worker.worker_id
                         FROM project_worker
                         WHERE project_worker.project_id = project.id
                         )

) * (
    YEAR(project.finish_date)*12 + MONTH(project.finish_date)-
    YEAR(project.start_date)*12 + MONTH(project.start_date)
    )
AS PRICE

FROM project
ORDER BY project.id;